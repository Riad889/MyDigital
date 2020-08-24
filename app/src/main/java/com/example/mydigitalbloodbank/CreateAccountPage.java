package com.example.mydigitalbloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateAccountPage extends AppCompatActivity implements View.OnClickListener {

    private EditText editText1,editText2;
    private Button b11,b112;
    private TextView t11;
    private ProgressBar pb1;
    private FirebaseAuth mAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_page);
        mAuth = FirebaseAuth.getInstance();
        editText1=findViewById(R.id.ed1);
        editText2=findViewById(R.id.ed2);
        b11=findViewById(R.id.b12);
        b112=findViewById(R.id.b13);
        t11=findViewById(R.id.t12);
        pb1=findViewById(R.id.p12);
        b11.setOnClickListener(this);
        b112.setOnClickListener(this);
        t11.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.b12:
                userRegister();
                break;
            case R.id.t12:
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                break;
            case R.id.b13:
                Intent in=new Intent(getApplicationContext(),Information.class);
                startActivity(in);
                break;
        }
    }

    public void userRegister() {
        String email = editText1.getText().toString().trim();
        String password = editText2.getText().toString().trim();
        pb1.setVisibility(View.VISIBLE);
        if (email.isEmpty()) {
            editText1.setError("Enter an email address");
            editText1.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editText1.setError("Enter a valid email address");
            editText1.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            editText2.setError("Enter the password");
            editText2.requestFocus();
            return;
        }
        if (password.length() < 6) {
            editText2.setError("Enter a valid password");
            editText2.requestFocus();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                pb1.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Reg is complete",Toast.LENGTH_SHORT).show();

                } else {
                   if(task.getException() instanceof FirebaseAuthUserCollisionException)
                   {
                       Toast.makeText(getApplicationContext(),"User is already Registered",Toast.LENGTH_SHORT).show();
                   }
                   else
                   {
                       Toast.makeText(getApplicationContext(),"Error : "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                   }

                }

            }
        });
    }
}


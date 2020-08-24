package com.example.mydigitalbloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private EditText editText1,editText2;
    private Button b11;
    private TextView t11;
    private ProgressBar pb1;
    private FirebaseAuth mAuth;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth=FirebaseAuth.getInstance();
        editText1=findViewById(R.id.ett1);
        editText2=findViewById(R.id.ett2);
        pb1=findViewById(R.id.p1);
        b11=findViewById(R.id.bb1);
        t11=findViewById(R.id.t1);
        b11.setOnClickListener(this);
        t11.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bb1:
                UserLogin();


                break;
            case R.id.t1:
                Intent intent = new Intent(getApplicationContext(),CreateAccountPage.class);
                startActivity(intent);
                break;
        }

    }

    private void UserLogin() {
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
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {

                }
            }
        });
    }
}

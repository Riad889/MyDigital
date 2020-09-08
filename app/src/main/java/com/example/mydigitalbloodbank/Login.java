package com.example.mydigitalbloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.usage.NetworkStats;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private EditText editText1, editText2;
    private Button b11,b22;
    private TextView t11;
    private ProgressBar pb1;
    private FirebaseAuth mAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        editText1 = findViewById(R.id.ett1);
        editText2 = findViewById(R.id.ett2);
        pb1 = findViewById(R.id.p1);
        b11 = findViewById(R.id.bb1);
        t11 = findViewById(R.id.t1);
        b22=findViewById(R.id.bb2);
        b11.setOnClickListener(this);
        b22.setOnClickListener(this);
        t11.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bb1:
                UserLogin();
                break;
            case R.id.bb2:
                Intent newIntent = new Intent(getApplicationContext(),forget_password.class);
                startActivity(newIntent);
                break;
            case R.id.t1:
                Intent intent = new Intent(getApplicationContext(), Information.class);
                startActivity(intent);
                break;
        }

    }

    private void UserLogin() {
       final String email1 = editText1.getText().toString().trim();
        final String password = editText2.getText().toString().trim();
        pb1.setVisibility(View.VISIBLE);
        //DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("people_information");
        if (email1.isEmpty()) {
            editText1.setError("Enter an email address");
            editText1.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email1).matches()) {
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

        mAuth.signInWithEmailAndPassword(email1, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            pb1.setVisibility(View.GONE);
                            // Sign in success, update UI with the signed-in user's information
                            Intent intent=new Intent(getApplicationContext(),Edit_Information.class);
                            startActivity(intent);
                            //Animatoo.animateCard(getApplicationContext());




                        } else {
                            pb1.setVisibility(View.GONE);

                            Toast.makeText(getApplicationContext(),"Error : "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });











         //Query checkUser=databaseReference.orderByChild("email").equalTo(email1);
        //System.out.println(checkUser.get);
        //final DatabaseReference databaseReference1=checkUser.getRef();
       // NetworkStats.Bucket firebaseAuth;

        //DatabaseReference databaseReference2=FirebaseDatabase.getInstance().getReference("people_information");
       // databaseReference2.addValueEventListener(new ValueEventListener() {
           /* @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                InfoGather infoGather=snapshot.getValue(InfoGather.class);
                System.out.println(infoGather);
               if(infoGather.getEmail()==email1)
               {

               }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        /*checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    String pass=snapshot.child().child("password").getValue(String.class);
                    System.out.println(pass);
                    if(pass.equals(password))
                    {
                        Intent newIntent=new Intent(getApplicationContext(),Edit_Information.class);
                        startActivity(newIntent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Wrong Password",Toast.LENGTH_LONG).show();
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),"DataBase error",Toast.LENGTH_LONG).show();

            }
        });
        */
    }
}

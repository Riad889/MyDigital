package com.example.mydigitalbloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Information extends AppCompatActivity implements View.OnClickListener {
    private EditText et1,et2,et3,et4,et5,et6,et7,et8,et9,et10;
    private CheckBox ckk1;

    private FirebaseAuth mAuth;
    //FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
   // FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
    //String user_ID = firebaseUser.getUid();
    private Button b1;
    DatabaseReference dtr;
    String email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        dtr= FirebaseDatabase.getInstance().getReference().child("people_information");
        et1=(EditText)findViewById(R.id.ed1);
        et4=(EditText)findViewById(R.id.ed4);
        et5=(EditText)findViewById(R.id.ed5);
        et6=(EditText)findViewById(R.id.ed6);
        et7=(EditText)findViewById(R.id.ed7);
        et8=(EditText)findViewById(R.id.ed8);
        et9=(EditText)findViewById(R.id.edd1);
        et10=(EditText)findViewById(R.id.edd2);
        b1=(Button)findViewById(R.id.b12);
        ckk1=(CheckBox)findViewById(R.id.cb1);
        mAuth = FirebaseAuth.getInstance();
        b1.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {



        email=et9.getText().toString().trim();
       password=et10.getText().toString().trim();


        if (email.isEmpty()) {
            et9.setError("Enter an email address");
            et9.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            et9.setError("Enter a valid email address");
            et9.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            et10.setError("Enter the password");
            et10.requestFocus();
            return;
        }
        if (password.length() < 6) {
            et10.setError("Enter a valid password");
            et10.requestFocus();
            return;
        }
        //savedata();
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //pb1.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    //firebaseAuth = FirebaseAuth.getInstance();
                    //firebaseUser = firebaseAuth.getCurrentUser();
                    //user_ID = firebaseUser.getUid();
                    savedata();
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
    public void savedata()
    {
        String name=et1.getText().toString().trim();
        String age=et4.getText().toString().trim();
        String address=et5.getText().toString().trim();
        String bloodgroup=et6.getText().toString().trim();
        String dod=et7.getText().toString().trim();
        String phone=et8.getText().toString().trim();
        if(name.isEmpty())
        {
            et1.setError("Please enter your name");
            et1.requestFocus();
            return ;
        }
        if(age.isEmpty())
        {
            et4.setError("Enter your age");
            et4.requestFocus();
            return ;
        }
        if(address.isEmpty())
        {
            et5.setError("Enter your address");
            et5.requestFocus();
            return ;
        }
        if(address.length()<10)
        {
            et5.setError("Enter your full address");
            et5.requestFocus();
            return ;
        }
        if(bloodgroup.isEmpty())
        {
            et6.setError("Enter the blood group");
            et6.requestFocus();
            return ;

        }

        else if (bloodgroup=="O+")
        {
            et6.setError("Enter a valid blood group. you entered : "+bloodgroup+" "+age);
            et6.requestFocus();
            return ;
        }
        else
        {
            Toast.makeText(getApplicationContext(),"You entered right blood group",Toast.LENGTH_LONG).show();
        }
        if(dod.isEmpty())
        {
            et7.setError("Enter the date");
            et7.requestFocus();
            return ;
        }
        if(phone.isEmpty())
        {
            et8.setError("Enter the phone number");
            et8.requestFocus();
            return;
        }
        if(phone.length()>11)
        {
            et8.setError("Enter a valid phone number ");
            et8.requestFocus();
            return ;
        }
        if(ckk1.isChecked()) {
            FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
            dtr=firebaseDatabase.getReference(mAuth.getUid());
            InfoGather infoGather = new InfoGather(name, age, address, bloodgroup, dod, phone,email,password);
            dtr.setValue(infoGather);
            Toast.makeText(getApplicationContext(), "Create account successfully", Toast.LENGTH_SHORT).show();

            // finish();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Please agree",Toast.LENGTH_LONG).show();
        }
    }
    }

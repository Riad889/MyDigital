package com.example.mydigitalbloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Change_password extends AppCompatActivity {
    private ImageView imageView;
    private EditText editText;
    private Button button;
    private FirebaseUser firebaseUser;
    String userpass;
    private FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        //imageView=findViewById(R.id.image_view);
        editText=findViewById(R.id.etdtt1);
        button=findViewById(R.id.buttonone);
        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();

        System.out.println("password is "+userpass);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userpass=editText.getText().toString();
                if (userpass.isEmpty() || userpass.length()<6) {
                    editText.setError("Enter the password");
                    editText.requestFocus();
                    return;
                }


                firebaseUser.updatePassword(userpass).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(),"Update password successfully "+userpass,Toast.LENGTH_LONG).show();

                            //finish();
                            auth.signOut();
                            Intent newIntent=new Intent(getApplicationContext(),Login.class);
                            startActivity(newIntent);
                            //Animatoo.animateCard(getApplicationContext());

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Operation failed",Toast.LENGTH_LONG).show();
                        }

                    }
                });

            }
        });

    }
}

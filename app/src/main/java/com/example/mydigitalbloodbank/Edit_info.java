package com.example.mydigitalbloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Edit_info extends AppCompatActivity {
    private EditText et1,et2,et3,et4,et5,et6;
    private Button b1,b2;
    private TextView tt1;
    private ImageView imageView;
    private FirebaseAuth mAuth;
    private  FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);
        //imageView=findViewById(R.id.image_view);
        tt1=findViewById(R.id.ttt1);
        et1=findViewById(R.id.edt1);
        et2=findViewById(R.id.edt2);
        et3=findViewById(R.id.edt3);
        et4=findViewById(R.id.edt4);
        et5=findViewById(R.id.edt5);
        et6=findViewById(R.id.edt6);
        b1=findViewById(R.id.bb1);
        b2=findViewById(R.id.bb2);
        mAuth= FirebaseAuth.getInstance();
        firebaseDatabase= FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference=firebaseDatabase.getReference(mAuth.getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userprofile up=snapshot.getValue(userprofile.class);
                //System.out.println(up.getUsername()+" "+snapshot);
                et1.setText(up.getname());
                et3.setText(up.getAddress());
                et6.setText(up.getPhone());
                et4.setText(up.getBloodgroup());
                et2.setText(up.getAge());
                et5.setText(up.getDod());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=et1.getText().toString();
                String age=et2.getText().toString();
                String address=et3.getText().toString();
                String bloodgroup=et4.getText().toString();
                String dod=et5.getText().toString();
                String phone=et6.getText().toString();

                userprofile ns=new userprofile( name,  age,  address,  bloodgroup,  dod,  phone);
                databaseReference.setValue(ns);
                Toast.makeText(getApplicationContext(),"Save Successfully",Toast.LENGTH_LONG).show();
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent=new Intent(getApplicationContext(),Change_password.class);
                startActivity(newIntent);
                //Animatoo.animateCard(getApplicationContext());
            }
        });

    }
}

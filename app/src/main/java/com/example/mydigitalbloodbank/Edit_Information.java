package com.example.mydigitalbloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.view.Change;

public class Edit_Information extends AppCompatActivity {
    private TextView t1,t2,t3,t4,t5,t6,t7;
    private Button b1,b2;
    private ImageView iv;
    FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;
    userprofile up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__information);
        //iv=findViewById(R.id.image_view);
        t1=findViewById(R.id.tt1);
        t2=findViewById(R.id.tt2);
        t3=findViewById(R.id.tt3);
        t4=findViewById(R.id.tt4);
        t5=findViewById(R.id.tt5);
        t7=findViewById(R.id.userinfo);
        t6=findViewById(R.id.tt6);
        b1=findViewById(R.id.bb1);
        b2=findViewById(R.id.bb2);
        mAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference(mAuth.getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userprofile up=snapshot.getValue(userprofile.class);
                //System.out.println(up.getUsername()+" "+snapshot);
                t1.setText("Name: "+up.getname());
                t2.setText("Address : "+up.getAddress());
                t3.setText("Phone number : "+up.getPhone());
                t4.setText("Blood group : "+up.getBloodgroup());
                t5.setText("Age = "+up.getAge());
                t6.setText("Date of donation : "+up.getDod());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Edit_info.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Change_password.class);
                startActivity(intent);
            }
        });


    }
}

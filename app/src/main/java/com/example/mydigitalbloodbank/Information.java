package com.example.mydigitalbloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Information extends AppCompatActivity implements View.OnClickListener {
    private EditText et1,et2,et3,et4,et5,et6,et7,et8;
    private CheckBox ckk1;
    private Button b1;
    DatabaseReference dtr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        //dtr= FirebaseDatabase.getInstance().getReference("People_Information");
        et1=(EditText)findViewById(R.id.ed1);
        et4=(EditText)findViewById(R.id.ed4);
        et5=(EditText)findViewById(R.id.ed5);
        et6=(EditText)findViewById(R.id.ed6);
        et7=(EditText)findViewById(R.id.ed7);
        et8=(EditText)findViewById(R.id.ed8);
        b1=(Button)findViewById(R.id.b12);
        ckk1=(CheckBox)findViewById(R.id.cb1);
        b1.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        savedata();
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
        if(bloodgroup.matches("A+") || bloodgroup.matches("A-") || bloodgroup.matches("O+")  || bloodgroup.matches("O-")  || bloodgroup.matches("AB+") || bloodgroup.matches("AB-") || bloodgroup.matches("B+") || bloodgroup.matches("B-"))
        {
            Toast.makeText(getApplicationContext(),"You entered right blood group",Toast.LENGTH_SHORT).show();
        }
        else
        {
            et6.setError("Enter a valid blood group");
            et6.requestFocus();
            return ;
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
        if(phone.length()<11)
        {
            et8.setError("Enter a valid phone number ");
            et8.requestFocus();
            return ;
        }
        if(ckk1.isChecked()) {
            String key = dtr.push().getKey();
            InfoGather infoGather = new InfoGather(name, age, address, bloodgroup, dod, phone);
            dtr.child(key).setValue(infoGather);
            Toast.makeText(getApplicationContext(), "Create account successfully", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Please agree",Toast.LENGTH_LONG).show();
        }
    }
    }

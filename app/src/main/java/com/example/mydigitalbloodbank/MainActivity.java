package com.example.mydigitalbloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button bb1, bb2, bb3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bb1 = (Button) findViewById(R.id.b1);
        bb2 = (Button) findViewById(R.id.b2);
        bb3 = (Button) findViewById(R.id.b3);
        bb1.setOnClickListener(this);
        bb2.setOnClickListener(this);
        bb3.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.b1)
        {
            Intent intent=new Intent(getApplicationContext(),Login.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.b2)
        {
            Intent intent=new Intent(MainActivity.this,CreateAccountPage.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.b3)
        {
            Intent intent=new Intent(getApplicationContext(),searchview.class);
            startActivity(intent);
        }

    }
}

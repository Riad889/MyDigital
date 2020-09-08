package com.example.mydigitalbloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {

    private ProgressBar pb;
    private int i;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        pb=(ProgressBar)findViewById(R.id.progressBar);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                start();
                startApp();
            }
        });
        thread.start();
    }
    public void start(){
        for(i=20;i<=100;i=i+20)
        {
            try {
                Thread.sleep(1000);
                pb.setProgress(i);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
    public void startApp()
    {
        Intent it=new Intent(SplashScreen.this,MainActivity.class);
        startActivity(it);
        finish();
    }
}

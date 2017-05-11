package com.example.ajayp.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Thread t=new Thread()
        {
            @Override
            public void run(){
                try
                {
                    sleep(3*1000);
                    Intent i=new Intent(getBaseContext(),MainActivity.class);
                    startActivity(i);


                }
                catch (Exception e){}
            }
        };
        t.start();
    }
}


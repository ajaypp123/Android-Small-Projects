package com.example.ajayp.progressdialog;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    //ProgressBar pbw,pbh;
    ProgressDialog myPd_bar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button1);
        //pbh = (ProgressBar) findViewById(R.id.pbh);
        //pbw = (ProgressBar) findViewById(R.id.pbw);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressdialog = ProgressDialog.show(
                        MainActivity.this, "Please wait",
                        "Loading please wait..", true);

                progressdialog.setCancelable(true);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // put the thread to sleep for 5 seconds
                            Thread.sleep(5000);
                        } catch (Exception e) {
                        } finally {
                            intent = new Intent(MainActivity.this, Main2Activity.class);
                            startActivity(intent);
                        }
                        progressdialog.dismiss();
                    }
                }).start();

            }
        });
    }

    public void hbar(View v) {

        myPd_bar = new ProgressDialog(MainActivity.this);


        // myPd_bar=new ProgressDialog(MainActivity.this);
        myPd_bar.setMessage("Loading....");
        myPd_bar.setTitle("Please Wait..");
        myPd_bar.setProgressStyle(myPd_bar.STYLE_HORIZONTAL);
        myPd_bar.setProgress(0);
        myPd_bar.setMax(30);
        myPd_bar.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (myPd_bar.getProgress() <= myPd_bar.getMax()) {
                        Thread.sleep(1000);
                        handle.sendMessage(handle.obtainMessage());
                        if (myPd_bar.getProgress() == myPd_bar.getMax()) {
                            myPd_bar.dismiss();
                        }
                    }
                } catch (Exception e) {
                }
            }
        }).start();
    }

    Handler handle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            myPd_bar.incrementProgressBy(5);
        }
    };



}

package com.example.ajayp.fileopration;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    String Fname = "myFile";
    Button b1, b2;
    EditText ed1;
    TextView tv;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFile();
            }
        });
        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readFile();
            }
        });
        ed1 = (EditText)findViewById(R.id.editText);
        tv = (TextView)findViewById(R.id.textView);
    }
    public void readFile()
    {
        try{
            FileInputStream fi = openFileInput(Fname);
            InputStreamReader is = new InputStreamReader(fi);
            BufferedReader bufferedReader = new BufferedReader(is);
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;

          //  File file = new File(context.getFilesDir(), "myFile");

            while ((line= bufferedReader.readLine())!= null)
            {
                stringBuilder.append(line);
            }
            fi.close();
            is.close();
            tv.setText("Name:"+stringBuilder.toString());
            Toast.makeText(this, "Data Retrived:"+stringBuilder.toString(), Toast.LENGTH_SHORT).show();

        }catch (java.io.IOException e)
        {
            e.printStackTrace();
        }
    }
    public void saveFile()
    {
        try
        {
            FileOutputStream fos = openFileOutput(Fname, Context.MODE_PRIVATE);

            name = ed1.getText().toString();
            fos.write(name.getBytes());
            fos.close();
            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
        }
        catch(java.io.IOException e)
        {
            e.printStackTrace();
        }

    }
}


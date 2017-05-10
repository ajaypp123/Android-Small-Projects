package com.example.ajayp.databasedemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText na1, mar1, r1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        na1 = (EditText) findViewById(R.id.na);
        mar1 = (EditText) findViewById(R.id.mar);
        r1 = (EditText) findViewById(R.id.r);

    }

    public void ins(View v){
        StudentDBHelper studentDBHelper = new StudentDBHelper(this);
        SQLiteDatabase db = studentDBHelper.getWritableDatabase();

        String name = na1.getText().toString();
        String mark = mar1.getText().toString();

        ContentValues values = new ContentValues();
        values.put("sname",name);
        values.put("marks",mark);

        long row = db.insert("student",null,values);

        Toast.makeText(MainActivity.this,"row no :" + row,Toast.LENGTH_SHORT).show();
    }

    public void show(View v){
        StudentDBHelper studentDBHelper = new StudentDBHelper(this);
        SQLiteDatabase db = studentDBHelper.getReadableDatabase();

        String data[]={"sid","sname","marks"};

        Cursor c = db.query("student",data,null,null,null,null,null);
        //c.moveToPosition(1);
        String da = "";
        if(c.moveToFirst()){
            do{
                da = da + Integer.parseInt(c.getString(0)) + "\n" + c.getString(1) + "\n" + c.getString(2) + "\n\n" ;
            }while(c.moveToNext());
        }
        Toast.makeText(MainActivity.this,da,Toast.LENGTH_SHORT).show();
    }

    public void delete(View v){
        StudentDBHelper studentDBHelper = new StudentDBHelper(this);
        SQLiteDatabase db = studentDBHelper.getReadableDatabase();

        int row_table = Integer.parseInt(r1.getText().toString());

        db.delete("student", "sid=?",new String[]{String.valueOf(row_table)});

        Toast.makeText(MainActivity.this,"deleted",Toast.LENGTH_SHORT).show();
    }

    public void up(View v){
        StudentDBHelper studentDBHelper = new StudentDBHelper(this);
        SQLiteDatabase db = studentDBHelper.getReadableDatabase();

        String mark = mar1.getText().toString();
        int row_table = Integer.parseInt(r1.getText().toString());

        ContentValues values = new ContentValues();
        values.put("marks",mark);

        // updating row
        db.update("student", values, "sid=?", new String[]{String.valueOf(row_table)});

        Toast.makeText(MainActivity.this,"update",Toast.LENGTH_SHORT).show();
    }
}

package com.example.ajayp.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp31;
    TextView tracfk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        track = (TextView) findViewById(R.id.tr);

        mp31 = mp31.create(this,R.raw.song);

    }

    public void play(View v){

        if(mp31.isPlaying())
        {
            Toast.makeText(MainActivity.this,"Already Playing",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(MainActivity.this,"Song start",Toast.LENGTH_SHORT).show();
            mp31.start();
            String tra = mp31.getTrackInfo().toString();
            track.setText(tra);
        }

    }

    public void pause(View v){
        if(mp31.isPlaying())
        {
            Toast.makeText(MainActivity.this,"Song Pause",Toast.LENGTH_SHORT).show();
            mp31.pause();
        }
        else
        {
            Toast.makeText(MainActivity.this,"Song Alrady Pause",Toast.LENGTH_SHORT).show();
        }

    }

    public void resume(View v){
        if(mp31.isPlaying())
        {
            Toast.makeText(MainActivity.this,"Already Playing",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(MainActivity.this,"Song Resume",Toast.LENGTH_SHORT).show();
            mp31.start();
        }

    }

    public void stop(View v){
        Toast.makeText(MainActivity.this,"Song Stop",Toast.LENGTH_SHORT).show();
        mp31.stop();
    }

}

package com.example.ajayp.imageradio;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioButton car,game;
    ImageView img;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        car = (RadioButton) findViewById(R.id.car);
        game = (RadioButton)findViewById(R.id.game);
        rg = (RadioGroup) findViewById(R.id.rg);
        img = (ImageView) findViewById(R.id.img);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup rg, int i) {

                switch (i){
                    case R.id.car :
                        img.setImageResource(R.drawable.car);
                        break;
                    case R.id.game :
                        img.setImageResource(R.drawable.game);
                        break;
                }
            }
        });


       /* Thread th = new Thread(){
            public void run() {
                if(car.isChecked()){
                    img.setImageResource(R.drawable.car);
                }

                if (game.isChecked()){
                    img.setImageResource(R.drawable.game);
                }
            }
        };
        th.start();*/



    }
}

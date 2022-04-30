package com.app.manifold;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.manifold.R;
public class MxPlayerActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8;
    MediaPlayer mp,mp1,mp2,mp3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mx_player);
        b1 = findViewById(R.id.button7);
        b2 = findViewById(R.id.button8);
        b3 = findViewById(R.id.button9);
        b4 = findViewById(R.id.button10);
        b5 = findViewById(R.id.button11);
        b6 = findViewById(R.id.button12);
        b7 = findViewById(R.id.button13);
        b8 = findViewById(R.id.button14);
        mp = MediaPlayer.create(this,R.raw.chahu);
        mp1 = MediaPlayer.create(this,R.raw.hasil);
        mp2 = MediaPlayer.create(this,R.raw.karar);
        mp3 = MediaPlayer.create(this,R.raw.letme);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp1.start();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp1.pause();
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp2.start();
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp2.pause();
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp3.start();
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp3.pause();
            }
        });
    }

}
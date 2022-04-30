package com.app.manifold;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.app.manifold.R;
public class ToolsActivity extends AppCompatActivity {

    CardView c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);
        c1 = findViewById(R.id.cardView);
        c2 = findViewById(R.id.cardView1);
        c3 = findViewById(R.id.cardView2);
        c4 = findViewById(R.id.cardView3);
        c5 = findViewById(R.id.cardView4);
        c6 = findViewById(R.id.cardView5);
        c7 = findViewById(R.id.cardView6);
        c8 = findViewById(R.id.cardView7);
        c9 = findViewById(R.id.cardView8);
        c10 = findViewById(R.id.cardView9);
        c11 = findViewById(R.id.cardView10);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ToolsActivity.this,CalcActivity.class);
                startActivity(i);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ToolsActivity.this,BluetoothActivity.class));
            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ToolsActivity.this,WifiActivity.class));
            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ToolsActivity.this,CameraActivity.class));
            }
        });

        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ToolsActivity.this,FlashlightActivity.class));
            }
        });

        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ToolsActivity.this,MxPlayerActivity.class);
                startActivity(i);
            }
        });

        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ToolsActivity.this,BrowserActivity.class));
            }
        });

        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ToolsActivity.this,QuizzerActivity.class));
            }
        });

        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ToolsActivity.this,VideoRecActivity.class));
            }
        });

        c10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ToolsActivity.this,MessageActivity.class));
            }
        });

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ToolsActivity.this, PhoneActivity.class));
            }
        });
    }

    public void logoutPage(View view) {
        startActivity(new Intent(ToolsActivity.this,MainActivity.class));
        finish();
    }
}
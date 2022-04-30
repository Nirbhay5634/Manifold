package com.app.manifold;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.manifold.R;

import java.util.Locale;

public class CalcActivity extends AppCompatActivity {

    EditText e1,e2;
    Button b1,b2,b3,b4;
    TextView t1;
    TextToSpeech ts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        e1 = (EditText)findViewById(R.id.firstNmbr);
        e2 = (EditText)findViewById(R.id.scndnmbr);
        b1 = (Button)findViewById(R.id.sum);
        b2 = (Button)findViewById(R.id.sub);
        b3 = (Button)findViewById(R.id.mul);
        b4 = (Button)findViewById(R.id.div);
        t1 = (TextView)findViewById(R.id.textView2);
        ts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                ts.setSpeechRate(0.8f);
                ts.setLanguage(Locale.ENGLISH);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                if(s1.isEmpty()){
                    e1.setError("Enter 1st Number:");
                    return;
                }
                else{
                    if(s2.isEmpty()) {
                        e2.setError("Enter 2nd Number:");
                        return;
                    }
                    else{
                        Integer i1 = Integer.parseInt(s1);
                        Integer i2 = Integer.parseInt(s2);
                        Integer i = i1 + i2;
                        String s3 = Integer.toString(i);
                        t1.setText("Sum of " + i1 + " and " + i2 + " is " + s3);
                        Toast.makeText(CalcActivity.this, "SUM of " + i1 + " and " + i2 + " is " + s3 , Toast.LENGTH_SHORT).show();
                        ts.speak("SUM of " + i1 + " and " + i2 + " is " + s3,TextToSpeech.QUEUE_FLUSH,null);
                    }
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                if(s1.isEmpty()){
                    e1.setError("Enter 1st Number:");
                    return;
                }
                else {
                    if (s2.isEmpty()) {
                        e2.setError("Enter 2nd Number:");
                        return;
                    } else {
                        Integer i1 = Integer.parseInt(s1);
                        Integer i2 = Integer.parseInt(s2);
                        Integer i = i1 - i2;
                        String s3 = Integer.toString(i);
                        t1.setText("Sub of " + i1 + " and " + i2 + " is " + s3);
                        Toast.makeText(CalcActivity.this, "SUB of " + i1 + " and " + i2 + " is " + s3, Toast.LENGTH_SHORT).show();
                        ts.speak("SUB of " + i1 + " and " + i2 + " is " + s3, TextToSpeech.QUEUE_FLUSH, null);
                    }
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                if(s1.isEmpty()){
                    e1.setError("Enter 1st Number:");
                    return;
                }
                else {
                    if (s2.isEmpty()) {
                        e2.setError("Enter 2nd Number:");
                        return;
                    } else {
                        Integer i1 = Integer.parseInt(s1);
                        Integer i2 = Integer.parseInt(s2);
                        Integer i = i1 * i2;
                        String s3 = Integer.toString(i);
                        t1.setText("Mul of " + i1 + " and " + i2 + " is " + s3);
                        Toast.makeText(CalcActivity.this, "MUL of " + i1 + " and " + i2 + " is " + s3, Toast.LENGTH_SHORT).show();
                        ts.speak("MUL of " + i1 + " and " + i2 + " is " + s3, TextToSpeech.QUEUE_FLUSH, null);
                    }
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                if(s1.isEmpty()){
                    e1.setError("Enter 1st Number:");
                    return;
                }
                else {
                    if (s2.isEmpty()) {
                        e2.setError("Enter 2nd Number:");
                        return;
                    } else {
                        Integer i1 = Integer.parseInt(s1);
                        Integer i2 = Integer.parseInt(s2);
                        Integer i = i1 / i2;
                        String s3 = Integer.toString(i);
                        t1.setText("Div of " + i1 + " and " + i2 + " is " + s3);
                        Toast.makeText(CalcActivity.this, "DIV of " + i1 + " and " + i2 + " is " + s3, Toast.LENGTH_SHORT).show();
                        ts.speak("DIV of " + i1 + " and " + i2 + " is " + s3, TextToSpeech.QUEUE_FLUSH, null);
                    }
                }
            }
        });
    }
}
package com.app.manifold;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.app.manifold.R;
public class QuizzerActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizzer);
        e1 = findViewById(R.id.editText3);
        e2 = findViewById(R.id.editText4);
        e3 = findViewById(R.id.editText5);
        e4 = findViewById(R.id.editText6);
        b1 = findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().isEmpty()){
                    e1.setError("Fill username");
                    return;
                }
                if(e2.getText().toString().isEmpty()){
                    e2.setError("Fill Mobile Number");
                    return;
                }
                if(e2.getText().length()!=10){
                    e2.setError("Invalid Mobile Number");
                    return;
                }
                if(e3.getText().toString().isEmpty()){
                    e3.setError("Fill email");
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(e3.getText().toString()).matches()){
                    e3.setError("Invalid email");
                    return;
                }
                if(e4.getText().toString().isEmpty()){
                    e4.setError("Fill course");
                    return;
                }
                startActivity(new Intent(QuizzerActivity.this,QuizQuestionsActivity.class));
            }
        });
    }
}
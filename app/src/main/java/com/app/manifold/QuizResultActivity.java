package com.app.manifold;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app.manifold.R;
public class QuizResultActivity extends AppCompatActivity {
    TextView t1;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        t1 = findViewById(R.id.text_result);
        b1 = findViewById(R.id.button_tryAgain);
        b2 = findViewById(R.id.button_Quit);

        if(QuizQuestionsActivity.score>0){
            t1.setText("Congratulations,U passed,ur current score is " + QuizQuestionsActivity.score);
        }
        else{
            t1.setText("Better luck next Time, U failed");
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizResultActivity.this,QuizzerActivity.class));
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizResultActivity.this,ToolsActivity.class));
                finish();
            }
        });
    }
}
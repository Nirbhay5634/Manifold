package com.app.manifold;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.app.manifold.R;
public class PhoneActivity extends AppCompatActivity {
    Button b1;
    EditText e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        e1 = findViewById(R.id.editText_phnNum1);
        b1 = findViewById(R.id.button_calling);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().isEmpty()){
                    e1.setError("Fill Mobile Number");
                    return;
                }
                if(e1.getText().toString().length()!=10){
                    e1.setError("Invalid Mobile Number");
                    return;
                }
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("tel:"+e1.getText().toString()));
                startActivity(i);
            }
        });
    }
}
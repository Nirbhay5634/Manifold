package com.app.manifold;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.app.manifold.R;import com.hbb20.CountryCodePicker;

public class LoginViaOTP extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    CountryCodePicker ccp;
    Button b1;
    ProgressBar p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_via_otp);
        e1 = findViewById(R.id.editText7);
        e2 = findViewById(R.id.editText8);
        ccp = findViewById(R.id.ccp);
        ccp.registerCarrierNumberEditText(e2);
        e3 = findViewById(R.id.editText9);
        e4 = findViewById(R.id.editText10);
        b1 = findViewById(R.id.button3);
        p1 = findViewById(R.id.progressBar3);

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
                if(!Patterns.PHONE.matcher(e2.getText().toString()).matches() || e2.getText().toString().length()!=10){
                    e2.setError("Invalid Mobile Number");
                    return;
                }
                if(e3.getText().toString().isEmpty()){
                    e3.setError("Fill email");
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(e3.getText().toString()).matches()){
                    e3.setError("Invalid Email");
                    return;
                }
                if(e4.getText().toString().isEmpty()){
                    e4.setError("Fill password");
                    return;
                }
                if(e4.getText().toString().length()<6){
                    e4.setError("Password must be 6 characters");
                    return;
                }
                p1.setVisibility(View.VISIBLE);
                Intent i = new Intent(LoginViaOTP.this,VerifyOTP.class);
                i.putExtra("mobile",ccp.getFullNumberWithPlus().trim());
                startActivity(i);
                p1.setVisibility(View.INVISIBLE);
            }
        });
    }
}
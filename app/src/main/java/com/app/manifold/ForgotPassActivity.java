package com.app.manifold;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.manifold.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class ForgotPassActivity extends AppCompatActivity {
    EditText e1;
    Button b1;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);
        firebaseAuth = FirebaseAuth.getInstance();
        e1 = findViewById(R.id.editText_email);
        b1 = findViewById(R.id.button_pass);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                if(s1.isEmpty()){
                    e1.setError("Fill email Address");
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(s1).matches()){
                    e1.setError("Invalid email");
                    return;
                }
                firebaseAuth.sendPasswordResetEmail(s1).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(ForgotPassActivity.this, "Please check ur email", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(ForgotPassActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
package com.app.manifold;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.app.manifold.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

public class SignUp extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    Button b1;
    TextView t1;
    FirebaseAuth firebaseAuth;
    ProgressBar p1;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        e1 = findViewById(R.id.editText3);
        e2 = findViewById(R.id.editText4);
        e3 = findViewById(R.id.editText5);
        e4 = findViewById(R.id.editText6);
        b1 = findViewById(R.id.button2);

        p1 = (ProgressBar)findViewById(R.id.progressBar);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = e4.getText().toString();
                if(s1.isEmpty()){
                    e1.setError("Fill username");
                    return;
                }
                if(s2.isEmpty()){
                    e2.setError("Fill Mobile Number");
                    return;
                }
                if(s2.length()!=10){
                    e2.setError("Invalid Mobile Number");
                    return;
                }
                if(s3.isEmpty()){
                    e3.setError("Fill Email Address");
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(e3.getText().toString()).matches()){
                    e3.setError("Invalid Email Address");
                    return;
                }
                if(s4.isEmpty()){
                    e4.setError("Fill password");
                    return;
                }
                else{
                    if(s4.length()<6){
                        e4.setError("Password must be 6 characters");
                        return;
                    }
                }
                p1.setVisibility(View.VISIBLE);
                firebaseAuth.createUserWithEmailAndPassword(s3,s4).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            users users = new users(s1,s2,s3,s4);
                            databaseReference.child(s2).setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull @NotNull Task<Void> task) {
                                    Toast.makeText(SignUp.this, "ACCOUNT CREATED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                                    p1.setVisibility(View.INVISIBLE);
                                    Intent i = new Intent(SignUp.this,MainActivity.class);
                                    startActivity(i);
                                    finish();
                                }
                            });
                        }
                        else{
                            Toast.makeText(SignUp.this, "USERS EXIST", Toast.LENGTH_SHORT).show();
                            p1.setVisibility(View.INVISIBLE);
                            Intent i = new Intent(SignUp.this,MainActivity.class);
                            startActivity(i);
                            finish();
                        }
                    }
                });

            }
        });
    }

    public void SignInPage(View view) {
        startActivity(new Intent(SignUp.this,MainActivity.class));
    }
}
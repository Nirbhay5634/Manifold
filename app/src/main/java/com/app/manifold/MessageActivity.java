package com.app.manifold;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.manifold.R;
public class MessageActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    String s1;
    String s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        e1 = findViewById(R.id.editText_phnNum);
        e2 = findViewById(R.id.editText_sms);
        b1 = findViewById(R.id.button_sendSms);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = e1.getText().toString();
                s2 = e2.getText().toString();
                try{

                    if(s1.isEmpty()){
                        e1.setError("Fill Mobile Number");
                        return;
                    }
                    if(s1.length()!=10){
                        e1.setError("Invalid Mobile Number");
                        return;
                    }
                    if(s2.isEmpty()){
                        e2.setError("Fill Sms body");
                        return;
                    }
                    //Using SmsManager Api
                    SmsManager sm = SmsManager.getDefault();
                    sm.sendTextMessage(s1,null,s2,null,null);
                    Toast.makeText(MessageActivity.this, "SMS Sent", Toast.LENGTH_SHORT).show();



                    //Using Built in sms
                    /*Intent i = new Intent(Intent.ACTION_VIEW);
                    i.putExtra("sms_body","default content");
                    i.setType("vnd.android-dir/mms-sms");
                    startActivity(i);*/
                }
                catch(Exception e){
                    Toast.makeText(MessageActivity.this, "SMS Failed", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        });
    }
}

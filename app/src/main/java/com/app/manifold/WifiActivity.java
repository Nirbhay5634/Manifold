package com.app.manifold;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.app.manifold.R;
public class WifiActivity extends AppCompatActivity {
    ImageView ib;
    WifiManager wm;
    private  boolean wifi = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        ib = findViewById(R.id.imageView_wifi);
        wm = (WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wifi == false){
                    wm.setWifiEnabled(true);
                    wifi = true;
                    ib.setImageResource(R.drawable.wifioff);
                    Toast.makeText(WifiActivity.this, "Wifi Enabled", Toast.LENGTH_SHORT).show();
                }
                else{
                    wm.setWifiEnabled(false);
                    wifi = false;
                    ib.setImageResource(R.drawable.wifion);
                    Toast.makeText(WifiActivity.this, "Wifi Disabled", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
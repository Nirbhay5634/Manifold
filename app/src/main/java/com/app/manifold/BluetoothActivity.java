package com.app.manifold;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.app.manifold.R;

public class BluetoothActivity extends AppCompatActivity {
    ImageButton ib;
    BluetoothAdapter ba;
    private boolean blueTooth = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        ib = (ImageButton)findViewById(R.id.imageButton2);
        ba = BluetoothAdapter.getDefaultAdapter();
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(blueTooth == false){
                    ba.enable();
                    blueTooth = true;
                    ib.setImageResource(R.drawable.blueoff);
                    Toast.makeText(BluetoothActivity.this, "Bluetooth Enabled! ", Toast.LENGTH_SHORT).show();
                }
                else{
                    ba.disable();
                    blueTooth = false;
                    ib.setImageResource(R.drawable.blueon);
                    Toast.makeText(BluetoothActivity.this, "Bluetooth Disabled!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
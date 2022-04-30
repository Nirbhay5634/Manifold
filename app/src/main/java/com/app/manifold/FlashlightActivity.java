package com.app.manifold;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.app.manifold.R;
public class FlashlightActivity extends AppCompatActivity {
    ImageButton ib;
    CameraManager cm;
    private boolean torch = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashlight);
        ib = (ImageButton)findViewById(R.id.imageButton);
        cm = (CameraManager)getSystemService(CAMERA_SERVICE);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(torch == false) {
                    try {
                        String id = cm.getCameraIdList()[0];
                        cm.setTorchMode(id, true);
                        torch = true;
                        ib.setImageResource(R.drawable.flashoff);
                        Toast.makeText(FlashlightActivity.this, "Torch ON", Toast.LENGTH_SHORT).show();
                    } catch (CameraAccessException e) {

                    }
                }
                else{
                    try{
                        String id = cm.getCameraIdList()[0];
                        cm.setTorchMode(id,false);
                        torch = false;
                        ib.setImageResource(R.drawable.flaslight);
                        Toast.makeText(FlashlightActivity.this, "Torch OFF", Toast.LENGTH_SHORT).show();
                    }
                    catch (CameraAccessException e){

                    }
                }
            }
        });
    }
}
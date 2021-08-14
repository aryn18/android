package com.example.android;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Torwithtoggle extends AppCompatActivity {
    ImageButton imageButton;
    ToggleButton toggleButton;
    CameraManager cameraManager;
    private boolean torch = false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torwithtoggle);
        imageButton = findViewById(R.id.imageButton13);
        toggleButton = findViewById(R.id.toggleButton);
        cameraManager = (CameraManager)getSystemService(CAMERA_SERVICE);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    try{
                        String id = cameraManager.getCameraIdList()[0];
                        cameraManager.setTorchMode(id,true);
                        Toast.makeText(Torwithtoggle.this, "Torch is on", Toast.LENGTH_SHORT).show();
                    }catch (CameraAccessException ignored){

                    }
                }else{
                    try{
                        String id = cameraManager.getCameraIdList()[0];
                        cameraManager.setTorchMode(id,false);
                        Toast.makeText(Torwithtoggle.this, "Torch is off", Toast.LENGTH_SHORT).show();
                    }catch (CameraAccessException ignored){

                    }
                }
            }
        });
        imageButton.setOnClickListener(v -> {
            Intent intent = new Intent(Torwithtoggle.this, Torch.class);
            startActivity(intent);
            finish();
        });
    }
}
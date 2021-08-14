package com.example.android;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Torwithbutton extends AppCompatActivity {
    Button button, button1;
    ImageButton imageButton;
    CameraManager cameraManager;
    private boolean torch = false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torwithbutton);
        button = findViewById(R.id.button25);
        button1 = findViewById(R.id.button26);
        imageButton = findViewById(R.id.imageButton14);
        cameraManager = (CameraManager)getSystemService(CAMERA_SERVICE);
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                try {
                    String id = cameraManager.getCameraIdList()[0];
                    cameraManager.setTorchMode(id, true);
                    torch = true;
                }
                catch (CameraAccessException e){
                }
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                try{
                    String id = cameraManager.getCameraIdList()[0];
                    cameraManager.setTorchMode(id, false);
                    torch = false;
                }catch (CameraAccessException ignored){
                }
            }
        });
        imageButton.setOnClickListener(v -> {
            Intent intent = new Intent(Torwithbutton.this, Torch.class);
            startActivity(intent);
            finish();
        });
    }
}
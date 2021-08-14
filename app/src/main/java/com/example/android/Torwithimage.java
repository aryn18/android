package com.example.android;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Torwithimage extends AppCompatActivity {
    ImageButton imageButton, imageButton1;
    CameraManager cameraManager;
    private boolean torch = false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torwithimage);
        imageButton = findViewById(R.id.imageButton15);
        imageButton1 = findViewById(R.id.imageButton16);
        cameraManager = (CameraManager)getSystemService(CAMERA_SERVICE);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if(torch == false){
                    try{
                        String id = cameraManager.getCameraIdList()[0];
                        cameraManager.setTorchMode(id,true);
                        torch = true;
                        imageButton.setImageResource(R.drawable.on);
                    }catch (CameraAccessException e){

                    }
                }else{
                    try{
                        String id = cameraManager.getCameraIdList()[0];
                        cameraManager.setTorchMode(id,false);
                        torch = false;
                        imageButton.setImageResource(R.drawable.off);
                    }catch (CameraAccessException e){
                    }
                }
            }
        });
        imageButton1.setOnClickListener(v -> {
            Intent intent = new Intent(Torwithimage.this, Torch.class);
            startActivity(intent);
            finish();
        });
    }
}
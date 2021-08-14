package com.example.android;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class Torchsensor extends AppCompatActivity implements SensorEventListener {
    ImageView imageView;
    SensorManager sensorManager;
    Sensor sensor;
    ImageButton imageButton;
    CameraManager cameraManager;
    private  boolean torch =  false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torchsensor);
        imageView = findViewById(R.id.imageView4);
        imageButton = findViewById(R.id.imageButton8);
        imageButton.setOnClickListener(v -> {
            Intent intent = new Intent(Torchsensor.this, com.example.android.Sensors.class);
            startActivity(intent);
            finish();
        });
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this,sensor , SensorManager.SENSOR_DELAY_NORMAL);
        cameraManager = (CameraManager)getSystemService(CAMERA_SERVICE);
    }
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        float x1 = sensorEvent.values[0];
        float y1 = sensorEvent.values[1];
        float z1 = sensorEvent.values[2];

        int x = (int) x1;
        int y = (int) y1;
        int z = (int) z1;

        if (x != 0) //mtlb position change hua hai
        {
            try
            {
                String id =  cameraManager.getCameraIdList()[0];
                cameraManager.setTorchMode(id , true);
                torch = true;
                imageView.setImageResource(R.drawable.on);
            }
            catch(CameraAccessException e) {
            }
        }
        else
        {
            try
            {
                String id = cameraManager.getCameraIdList()[0];
                cameraManager.setTorchMode(id,false);
                torch = false;
                imageView.setImageResource(R.drawable.off);
            }
            catch(CameraAccessException e)
            {
            }
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Lightsensor extends AppCompatActivity implements SensorEventListener {
    ImageView imageView;
    MediaPlayer mediaPlayer;
    SensorManager sensorManager;
    ImageButton imageButton;
    Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lightsensor);
        imageView = findViewById(R.id.imageView);
        imageButton = findViewById(R.id.imageButton5);
        imageButton.setOnClickListener(v -> {
            mediaPlayer.pause();
            Intent intent = new Intent(Lightsensor.this, com.example.android.Sensors.class);
            startActivity(intent);
            finish();
        });
        mediaPlayer = MediaPlayer.create(this, R.raw.humam);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.values[0]>1)
        {
            mediaPlayer.start();
            imageView.setImageResource(R.drawable.on);
        }
        else
        {
            mediaPlayer.pause();
            imageView.setImageResource(R.drawable.off);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
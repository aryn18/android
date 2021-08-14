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
import android.widget.TextView;

public class Gravitysensor extends AppCompatActivity implements SensorEventListener {
    MediaPlayer mediaPlayer;
    ImageView imageView;
    SensorManager sensorManager;
    ImageButton imageButton;
    Sensor sensor;
    TextView textView,textView1,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravitysensor);
        mediaPlayer = MediaPlayer.create(this, R.raw.mishri);
        imageView = findViewById(R.id.imageView2);
        imageButton = findViewById(R.id.imageButton6);
        imageButton.setOnClickListener(view -> {
            mediaPlayer.pause();
            Intent intent = new Intent(Gravitysensor.this, com.example.android.Sensors.class);
            startActivity(intent);
            finish();
        });
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
        textView = findViewById(R.id.textView5);
        textView1 = findViewById(R.id.textView6);
        textView2 = findViewById(R.id.textView7);

    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x1 = sensorEvent.values[0];
        float y1 = sensorEvent.values[1];
        float z1 = sensorEvent.values[2];
        String string = Float.toString(x1);
        String string1 = Float.toString(y1);
        String string2 = Float.toString(z1);
        textView.setText(string);
        textView1.setText(string1);
        textView2.setText(string2);
        int x = (int)x1;
        int y = (int)y1;
        int z = (int)z1;

        if(z!=0) // It means position change hua hai
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
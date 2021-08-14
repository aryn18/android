package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class Sensors extends AppCompatActivity {
    Button button, button1, button2, button3;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);
        button = findViewById(R.id.button11);
        button1 = findViewById(R.id.button12);
        button2 = findViewById(R.id.button13);
        button3 = findViewById(R.id.button14);
        imageButton = findViewById(R.id.imageButton3);

        button.setOnClickListener(view -> {
            Intent intent = new Intent(Sensors.this, Lightsensor.class);
            startActivity(intent);
            finish();
        });

        button1.setOnClickListener(view -> {
            Intent intent1 = new Intent(Sensors.this, Gravitysensor.class);
            startActivity(intent1);
            finish();
        });

        button2.setOnClickListener(view -> {
            Intent intent2 = new Intent(Sensors.this, Tiltsensor.class);
            startActivity(intent2);
            finish();
        });

        button3.setOnClickListener(view -> {
            Intent intent3 = new Intent(Sensors.this, Torchsensor.class);
            startActivity(intent3);
            finish();
        });

        imageButton.setOnClickListener(view -> {
            Intent back = new Intent(Sensors.this, Appsmenu.class);
            startActivity(back);
            finish();
        });
    }
}
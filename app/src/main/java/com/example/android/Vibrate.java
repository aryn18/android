package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.Button;
import android.widget.ImageButton;

public class Vibrate extends AppCompatActivity {
    Button button;
    Vibrator vib;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrate);
        button = findViewById(R.id.button42);
        imageButton = findViewById(R.id.imageButton28);
        vib = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        button.setOnClickListener(v -> vib.vibrate(2000));
        imageButton.setOnClickListener(v -> {
            Intent back = new Intent(Vibrate.this, Moreapps.class);
            startActivity(back);
            finish();
        });
    }
}
package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class Moreapps extends AppCompatActivity {
    Button button, button1, button2, button3, button4, button5;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moreapps);
        button = findViewById(R.id.button37);
        button1 = findViewById(R.id.button38);
        button2 = findViewById(R.id.button39);
        button3 = findViewById(R.id.button40);
        button4 = findViewById(R.id.button41);
        button5 = findViewById(R.id.button71);
        imageButton = findViewById(R.id.imageButton27);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(Moreapps.this, MediaPlayer.class);
            startActivity(intent);
            finish();
        });

        button1.setOnClickListener(v -> {
            Intent intent1 = new Intent(Moreapps.this, VideoPlayer.class);
            startActivity(intent1);
            finish();
        });

        button2.setOnClickListener(v -> {
            Intent intent2 = new Intent(Moreapps.this, Webbrowser.class);
            startActivity(intent2);
            finish();
        });

        button3.setOnClickListener(v -> {
            Intent intent3 = new Intent(Moreapps.this, Calculator.class);
            startActivity(intent3);
            finish();
        });

        button4.setOnClickListener(v -> {
            Intent intent4 = new Intent(Moreapps.this, Vibrate.class);
            startActivity(intent4);
            finish();
        });

        button5.setOnClickListener(v -> {
            Intent intent4 = new Intent(Moreapps.this, Realtime.class);
            startActivity(intent4);
            finish();
        });

        imageButton.setOnClickListener(v -> {
            Intent back = new Intent(Moreapps.this, Appsmenu.class);
            startActivity(back);
            finish();
        });

    }
}
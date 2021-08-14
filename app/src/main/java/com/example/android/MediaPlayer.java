package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MediaPlayer extends AppCompatActivity {
    Button button, button1, button2;
    android.media.MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        button = findViewById(R.id.button44);
        button1 = findViewById(R.id.button45);
        button2 = findViewById(R.id.button46);
        mediaPlayer = android.media.MediaPlayer.create(this, R.raw.humam);
        button.setOnClickListener(view -> mediaPlayer.start());
        button1.setOnClickListener(view -> mediaPlayer.pause());
        button2.setOnClickListener(v -> {
            mediaPlayer.pause();
            Intent intent = new Intent(MediaPlayer.this, MediaPlayer1.class);
            startActivity(intent);
            finish();
        });
    }
}
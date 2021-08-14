package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class MediaPlayer1 extends AppCompatActivity {
    Button button, button1, button2;
    ImageButton imageButton;
    android.media.MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player1);
        button = findViewById(R.id.button47);
        button2 = findViewById(R.id.button48);
        button1 = findViewById(R.id.button49);
        imageButton = findViewById(R.id.imageButton30);
        mediaPlayer = android.media.MediaPlayer.create(this, R.raw.mishri);
        button.setOnClickListener(view -> mediaPlayer.start());
        button1.setOnClickListener(view -> mediaPlayer.pause());
        button2.setOnClickListener(v -> {
            mediaPlayer.pause();
            Intent intent = new Intent(MediaPlayer1.this, MediaPlayer.class);
            startActivity(intent);
            finish();
        });
        imageButton.setOnClickListener(v -> {
            mediaPlayer.pause();
            Intent back = new Intent(MediaPlayer1.this, Appsmenu.class);
            startActivity(back);
            finish();
        });
    }
}
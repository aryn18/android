package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer1 extends AppCompatActivity {
    Button button;
    VideoView videoView;
    ImageButton imageButton;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player1);
        button = findViewById(R.id.button51);
        imageButton = findViewById(R.id.imageButton31);
        videoView = findViewById(R.id.videoView3);
        mediaController = new MediaController(this);
        videoView.setVideoPath("android.resource://" +getPackageName()+ "/" +R.raw.video1);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();
        button.setOnClickListener(v -> {
            Intent intent = new Intent(VideoPlayer1.this, VideoPlayer.class);
            startActivity(intent);
            finish();
        });

        imageButton.setOnClickListener(v -> {
            Intent intent1 = new Intent(VideoPlayer1.this, Moreapps.class);
            startActivity(intent1);
            finish();
        });
    }
}
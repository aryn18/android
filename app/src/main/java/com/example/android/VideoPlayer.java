package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer extends AppCompatActivity {
    Button button;
    VideoView videoView;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        button = findViewById(R.id.button50);
        videoView = findViewById(R.id.videoView2);
        mediaController = new MediaController(this);
        videoView.setVideoPath("android.resource://" +getPackageName()+ "/" +R.raw.video);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();
        button.setOnClickListener(v -> {
            Intent intent = new Intent(VideoPlayer.this, VideoPlayer1.class);
            startActivity(intent);
            finish();
        });
    }
}
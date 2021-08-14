package com.example.android;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends AppCompatActivity {
    VideoView videoView;
    MediaController mediaController;
    Button button;
    Uri uri;
    ImageButton imageButton;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        assert data != null;
        uri=data.getData();
        videoView.setVideoURI(uri);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        button = findViewById(R.id.button21);
        imageButton = findViewById(R.id.imageButton11);
        videoView = findViewById(R.id.videoView);
        mediaController=new MediaController(this);
        button.setOnClickListener(v -> {
            Intent i = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            startActivityForResult(i,5);
        });
        imageButton.setOnClickListener(v -> {
            Intent back = new Intent(Video.this,Mobiletools.class);
            startActivity(back);
            finish();
        });
    }
}
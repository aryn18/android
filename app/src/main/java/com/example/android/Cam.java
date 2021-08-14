package com.example.android;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Cam extends AppCompatActivity {
    ImageView imageView;
    Button button;
    ImageButton imageButton;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==10) {
            assert data != null;
            Bitmap bm = (Bitmap)data.getExtras().get("data");
            imageView.setImageBitmap(bm);
        }
        else {
            Toast.makeText(this, "Image is not captured", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam);
        imageView = findViewById(R.id.imageView5);
        button = findViewById(R.id.button20);
        imageButton = findViewById(R.id.imageButton10);
        button.setOnClickListener(v -> {
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i,10);
        });
        imageButton.setOnClickListener(v -> {
            Intent back = new Intent(Cam.this,Mobiletools.class);
            startActivity(back);
            finish();
        });
    }
}
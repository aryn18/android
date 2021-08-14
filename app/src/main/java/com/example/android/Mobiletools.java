package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class Mobiletools extends AppCompatActivity {
    Button button, button1, button2, button3, button4;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobiletools);
        button = findViewById(R.id.button15);
        button1 = findViewById(R.id.button16);
        button2 = findViewById(R.id.button17);
        button3 = findViewById(R.id.button18);
        button4 = findViewById(R.id.button19);
        imageButton = findViewById(R.id.imageButton9);

        button.setOnClickListener(view -> {
            Intent intent = new Intent(Mobiletools.this, Bluetooth.class);
            startActivity(intent);
            finish();
        });

        button1.setOnClickListener(view -> {
            Intent intent1 = new Intent(Mobiletools.this, Cam.class);
            startActivity(intent1);
            finish();
        });

        button2.setOnClickListener(view -> {
            Intent intent2 = new Intent(Mobiletools.this, Wifi.class);
            startActivity(intent2);
            finish();
        });

        button3.setOnClickListener(view -> {
            Intent intent3 = new Intent(Mobiletools.this, Video.class);
            startActivity(intent3);
            finish();
        });

       button4.setOnClickListener(view -> {
            Intent intent4 = new Intent(Mobiletools.this, Torch.class);
            startActivity(intent4);
            finish();
        });

        imageButton.setOnClickListener(view -> {
            Intent back = new Intent(Mobiletools.this, Appsmenu.class);
            startActivity(back);
            finish();
        });
    }
}
package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class Wifi extends AppCompatActivity {
    Button button, button1, button2;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        button = findViewById(R.id.button27);
        button1 = findViewById(R.id.button28);
        button2 = findViewById(R.id.button29);
        imageButton = findViewById(R.id.imageButton17);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(Wifi.this, Wifiwithimage.class);
            startActivity(intent);
            finish();
        });

        button1.setOnClickListener(v -> {
            Intent intent1 = new Intent(Wifi.this, Wifiwithbutton.class);
            startActivity(intent1);
            finish();
        });

        button2.setOnClickListener(v -> {
            Intent intent2 = new Intent(Wifi.this, Wifiwithtoggle.class);
            startActivity(intent2);
            finish();
        });

        imageButton.setOnClickListener(v -> {
            Intent intent3 = new Intent(Wifi.this, Mobiletools.class);
            startActivity(intent3);
            finish();
        });
    }
}
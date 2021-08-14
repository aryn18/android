package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class Bluetooth extends AppCompatActivity {
    Button button, button1, button2;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        button = findViewById(R.id.button32);
        button1 = findViewById(R.id.button33);
        button2 = findViewById(R.id.button34);
        imageButton = findViewById(R.id.imageButton22);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(Bluetooth.this, Bluewithimage.class);
            startActivity(intent);
            finish();
        });

        button1.setOnClickListener(v -> {
            Intent intent1 = new Intent(Bluetooth.this, Bluewithbutton.class);
            startActivity(intent1);
            finish();
        });

        button2.setOnClickListener(v -> {
            Intent intent2 = new Intent(Bluetooth.this, Bluewithtoggle.class);
            startActivity(intent2);
            finish();
        });

        imageButton.setOnClickListener(v -> {
            Intent back = new Intent(Bluetooth.this, Mobiletools.class);
            startActivity(back);
            finish();
        });
    }
}
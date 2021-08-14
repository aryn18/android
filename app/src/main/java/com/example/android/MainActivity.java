package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button, button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button75);
        button2 = findViewById(R.id.button81);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Otp1.class);
            startActivity(intent);
            finish();
        });

        button1.setOnClickListener(view -> {
            Intent intent1 = new Intent(MainActivity.this, Email.class);
            startActivity(intent1);
            finish();
        });

        button2.setOnClickListener(view -> {
            Intent intent2 = new Intent(MainActivity.this, Sign.class);
            startActivity(intent2);
            finish();
        });
    }
}
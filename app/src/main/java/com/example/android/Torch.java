package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class Torch extends AppCompatActivity {
    Button button, button1, button2;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torch);
        button = findViewById(R.id.button22);
        button1 = findViewById(R.id.button23);
        button2 = findViewById(R.id.button24);
        imageButton = findViewById(R.id.imageButton12);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(Torch.this, Torwithimage.class);
            startActivity(intent);
            finish();
        });

        button1.setOnClickListener(v -> {
            Intent intent1 = new Intent(Torch.this, Torwithbutton.class);
            startActivity(intent1);
            finish();
        });

        button2.setOnClickListener(v -> {
            Intent intent2 = new Intent(Torch.this, Torwithtoggle.class);
            startActivity(intent2);
            finish();
        });

        imageButton.setOnClickListener(v -> {
            Intent intent3 = new Intent(Torch.this, Mobiletools.class);
            startActivity(intent3);
            finish();
        });
    }
}
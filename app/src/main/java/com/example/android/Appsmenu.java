package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class Appsmenu extends AppCompatActivity {
    Button button, button1, button2, button3, button4, button5;
    ImageButton imageButton;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appsmenu);
        button = findViewById(R.id.button2);
        button1 = findViewById(R.id.button3);
        button2 = findViewById(R.id.button4);
        button3 = findViewById(R.id.button5);
        button4 = findViewById(R.id.button6);
        button5 = findViewById(R.id.button76);
        firebaseAuth = FirebaseAuth.getInstance();
        imageButton = findViewById(R.id.imageButton);

        button.setOnClickListener(view -> {
            Intent intent = new Intent(Appsmenu.this, Texttospe.class);
            startActivity(intent);
            finish();
        });

        button1.setOnClickListener(view -> {
            Intent intent1 = new Intent(Appsmenu.this, Mobiletools.class);
            startActivity(intent1);
            finish();
        });

        button2.setOnClickListener(view -> {
            Intent intent2 = new Intent(Appsmenu.this, Sensors.class);
            startActivity(intent2);
            finish();
        });

        button3.setOnClickListener(view -> {
            Intent intent3 = new Intent(Appsmenu.this, Quiz.class);
            startActivity(intent3);
            finish();
        });

        button4.setOnClickListener(view -> {
            Intent intent4 = new Intent(Appsmenu.this, Moreapps.class);
            startActivity(intent4);
            finish();
        });

        button5.setOnClickListener(view -> {
            firebaseAuth.signOut();
            Intent intent5 = new Intent(Appsmenu.this, MainActivity.class);
            startActivity(intent5);
            finish();
        });

        imageButton.setOnClickListener(view -> {
            Intent back = new Intent(Appsmenu.this, Sign2.class);
            startActivity(back);
            finish();
        });
    }
}
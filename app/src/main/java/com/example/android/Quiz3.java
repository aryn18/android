package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

public class Quiz3 extends AppCompatActivity {
    Button button;
    RadioButton radioButton, radioButton1, radioButton2, radioButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);
        button = findViewById(R.id.button10);
        radioButton = findViewById(R.id.radioButton9);
        radioButton1 = findViewById(R.id.radioButton10);
        radioButton2 = findViewById(R.id.radioButton11);
        radioButton3 = findViewById(R.id.radioButton12);
        button.setOnClickListener(view -> {
            if (radioButton3.isChecked())
            {
                ++Quiz.score;
            } else
            {
                --Quiz.score;
            }
            Intent intent = new Intent(Quiz3.this, Quiz4.class);
            startActivity(intent);
            finish();
        });
    }
}
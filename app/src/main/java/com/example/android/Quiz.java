package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

public class Quiz extends AppCompatActivity {
    Button button;
    RadioButton radioButton, radioButton1, radioButton2, radioButton3;
    static int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        button = findViewById(R.id.button8);
        radioButton = findViewById(R.id.radioButton);
        radioButton1 = findViewById(R.id.radioButton2);
        radioButton2 = findViewById(R.id.radioButton3);
        radioButton3 = findViewById(R.id.radioButton4);
        button.setOnClickListener(view -> {
            score = 0;
            if(radioButton2.isChecked())
            {
                ++score;
            }
            else
            {
                --score;
            }
            Intent intent = new Intent(Quiz.this, Quiz2.class);
            startActivity(intent);
            finish();
        });
    }
}
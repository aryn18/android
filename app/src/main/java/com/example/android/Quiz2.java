package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

public class Quiz2 extends AppCompatActivity {
    Button button;
    RadioButton radioButton, radioButton1, radioButton2, radioButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);
        button = findViewById(R.id.button9);
        radioButton = findViewById(R.id.radioButton5);
        radioButton1 = findViewById(R.id.radioButton6);
        radioButton2 = findViewById(R.id.radioButton7);
        radioButton3 = findViewById(R.id.radioButton8);
        button.setOnClickListener(view -> {
            if(radioButton1.isChecked())
            {
                ++Quiz.score;
            }
            else
            {
                --Quiz.score;
            }
            Intent intent = new Intent(Quiz2.this, Quiz3.class);
            startActivity(intent);
            finish();
        });
    }
}
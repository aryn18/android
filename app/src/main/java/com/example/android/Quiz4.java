package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

public class Quiz4 extends AppCompatActivity {
    TextView textView;
    TextToSpeech textToSpeech;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4);
        imageButton = findViewById(R.id.imageButton4);
        textView = findViewById(R.id.textView4);
        textView.setText("Your score is: " +Quiz.score);
        textToSpeech = new TextToSpeech(this, i -> {
            textToSpeech.setLanguage(Locale.ENGLISH);
            textToSpeech.setSpeechRate(0.9f);
            String string = textView.getText().toString();
            textToSpeech.speak(string, TextToSpeech.QUEUE_FLUSH, null);
        });
        imageButton.setOnClickListener(view -> {
            Intent back = new Intent(Quiz4.this, Appsmenu.class);
            startActivity(back);
            finish();
        });
    }
}
package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Locale;

public class Texttospe extends AppCompatActivity {
    ImageButton imageButton;
    Button button;
    EditText editText;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texttospe);
        imageButton = findViewById(R.id.imageButton2);
        button = findViewById(R.id.button7);
        editText = findViewById(R.id.editText);
        textToSpeech = new TextToSpeech(this, i -> {
            textToSpeech.setLanguage(Locale.ENGLISH);
            textToSpeech.setSpeechRate(0.8f);
        });
        button.setOnClickListener(view -> {
            String string = editText.getText().toString();
            textToSpeech.speak(string, TextToSpeech.QUEUE_FLUSH, null);
        });
        imageButton.setOnClickListener(view -> {
            Intent back = new Intent(Texttospe.this, Appsmenu.class);
            startActivity(back);
            finish();
        });

    }
}
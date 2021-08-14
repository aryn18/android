package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

public class Calculator extends AppCompatActivity {
    EditText editText, editText1;
    TextView textView;
    ImageButton imageButton;
    Button button, button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, button16, button17, button18;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        editText = findViewById(R.id.editText3);
        editText1 = findViewById(R.id.editText4);
        textView = findViewById(R.id.textView11);
        imageButton = findViewById(R.id.imageButton32);
        button = findViewById(R.id.button52);
        button1 = findViewById(R.id.button53);
        button2 = findViewById(R.id.button54);
        button3 = findViewById(R.id.button55);
        button4 = findViewById(R.id.button56);
        button5 = findViewById(R.id.button57);
        button6 = findViewById(R.id.button58);
        button7 = findViewById(R.id.button59);
        button8 = findViewById(R.id.button60);
        button9 = findViewById(R.id.button61);
        button10 = findViewById(R.id.button62);
        button11 = findViewById(R.id.button63);
        button12 = findViewById(R.id.button64);
        button13 = findViewById(R.id.button65);
        button14 = findViewById(R.id.button66);
        button15 = findViewById(R.id.button67);
        button16 = findViewById(R.id.button68);
        button17 = findViewById(R.id.button69);
        button18 = findViewById(R.id.button70);
        textToSpeech = new TextToSpeech(this, i -> {
            textToSpeech.setLanguage(Locale.ENGLISH);
            textToSpeech.setSpeechRate(0.6f);
        });
        editText.setOnClickListener(view -> {
            button.setOnClickListener(view14 -> editText.setText(editText.getText() + "1"));
            button1.setOnClickListener(view121 -> editText.setText(editText.getText() + "2"));
            button2.setOnClickListener(view117 -> editText.setText(editText.getText() + "3"));
            button3.setOnClickListener(view110 -> editText.setText(editText.getText() + "4"));
            button4.setOnClickListener(view123 -> editText.setText(editText.getText() + "5"));
            button5.setOnClickListener(view19 -> editText.setText(editText.getText() + "6"));
            button6.setOnClickListener(view118 -> editText.setText(editText.getText() + "7"));
            button7.setOnClickListener(view124 -> editText.setText(editText.getText() + "8"));
            button8.setOnClickListener(view13 -> editText.setText(editText.getText() + "9"));
            button9.setOnClickListener(view120 -> editText.setText(editText.getText() + "0"));
            button10.setOnClickListener(view18 -> editText.setText(editText.getText() + "."));
            button11.setOnClickListener(view122 -> editText.setText(""));
        });
        editText1.setOnClickListener(view -> {
            button.setOnClickListener(view116 -> editText1.setText(editText1.getText() + "1"));
            button1.setOnClickListener(view15 -> editText1.setText(editText1.getText() + "2"));
            button2.setOnClickListener(view17 -> editText1.setText(editText1.getText() + "3"));
            button3.setOnClickListener(view16 -> editText1.setText(editText1.getText() + "4"));
            button4.setOnClickListener(view12 -> editText1.setText(editText1.getText() + "5"));
            button5.setOnClickListener(view119 -> editText1.setText(editText1.getText() + "6"));
            button6.setOnClickListener(view111 -> editText1.setText(editText1.getText() + "7"));
            button7.setOnClickListener(view113 -> editText1.setText(editText1.getText() + "8"));
            button8.setOnClickListener(view114 -> editText1.setText(editText1.getText() + "9"));
            button9.setOnClickListener(view1 -> editText1.setText(editText1.getText() + "0"));
            button10.setOnClickListener(view115 -> editText1.setText(editText1.getText() + "."));
            button11.setOnClickListener(view112 -> editText1.setText(""));
        });
        button12.setOnClickListener(view -> {
            String s1 = editText.getText().toString();
            String s2 = editText1.getText().toString();
            Float f1 = Float.parseFloat(s1);
            Float f2 = Float.parseFloat(s2);
            float f3 = f1 + f2;
            String s3 = Float.toString(f3);
            textView.setText(s3);
            textToSpeech.speak(s3, TextToSpeech.QUEUE_FLUSH, null);
        });
        button13.setOnClickListener(view -> {
            String s1 = editText.getText().toString();
            String s2 = editText1.getText().toString();
            Float f1 = Float.parseFloat(s1);
            Float f2 = Float.parseFloat(s2);
            float f3 = f1 - f2;
            String s3 = Float.toString(f3);
            textView.setText(s3);
            textToSpeech.speak(s3, TextToSpeech.QUEUE_FLUSH, null);
        });
        button14.setOnClickListener(view -> {
            String s1 = editText.getText().toString();
            String s2 = editText1.getText().toString();
            Float f1 = Float.parseFloat(s1);
            Float f2 = Float.parseFloat(s2);
            float f3 = f1 * f2;
            String s3 = Float.toString(f3);
            textView.setText(s3);
            textToSpeech.speak(s3, TextToSpeech.QUEUE_FLUSH, null);
        });
        button15.setOnClickListener(view -> {
            String s1 = editText.getText().toString();
            String s2 = editText1.getText().toString();
            Float f1 = Float.parseFloat(s1);
            Float f2 = Float.parseFloat(s2);
            float f3 = f1 / f2;
            String s3 = Float.toString(f3);
            textView.setText(s3);
            textToSpeech.speak(s3, TextToSpeech.QUEUE_FLUSH, null);
        });
        button16.setOnClickListener(view -> {
            String s1 = editText.getText().toString();
            double d1 = Double.parseDouble(s1);
            double a = Math.toRadians(d1);
            double c = Math.sin(a);
            String s3 = Double.toString(c);
            textView.setText(s3);
            textToSpeech.speak(s3, TextToSpeech.QUEUE_FLUSH, null);
        });
        button17.setOnClickListener(view -> {
            String s1 = editText.getText().toString();
            double d1 = Double.parseDouble(s1);
            double a = Math.toRadians(d1);
            double c = Math.cos(a);
            String s3 = Double.toString(c);
            textView.setText(s3);
            textToSpeech.speak(s3, TextToSpeech.QUEUE_FLUSH, null);
        });
        button18.setOnClickListener(view -> {
            String s1 = editText.getText().toString();
            double d1 = Double.parseDouble(s1);
            double a = Math.toRadians(d1);
            double c = Math.tan(a);
            String s3 = Double.toString(c);
            textView.setText(s3);
            textToSpeech.speak(s3, TextToSpeech.QUEUE_FLUSH, null);
        });
        imageButton.setOnClickListener(v -> {
            Intent intent = new Intent(Calculator.this, Moreapps.class);
            startActivity(intent);
            finish();
        });
    }
}
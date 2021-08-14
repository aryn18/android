package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.hbb20.CountryCodePicker;

public class Otp1 extends AppCompatActivity {
    CountryCodePicker countryCodePicker;
    EditText editText;
    Button button;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp1);

        editText = findViewById(R.id.editText9);
        imageButton = findViewById(R.id.imageButton35);
        countryCodePicker = (CountryCodePicker) findViewById(R.id.countryCodeHolder);
        countryCodePicker.registerCarrierNumberEditText(editText);
        button = findViewById(R.id.button73);

        button.setOnClickListener(v -> {
            Intent i = new Intent(Otp1.this, Otp2.class);
            i.putExtra("mobile", countryCodePicker.getFullNumberWithPlus().trim());
            startActivity(i);
        });

        imageButton.setOnClickListener(view -> {
            Intent back = new Intent(Otp1.this, MainActivity.class);
            startActivity(back);
            finish();
        });

    }
}
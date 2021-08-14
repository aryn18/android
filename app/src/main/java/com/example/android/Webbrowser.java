package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Webbrowser extends AppCompatActivity {
    Button button;
    ImageButton imageButton;
    EditText editText;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webbrowser);
        button = findViewById(R.id.button43);
        imageButton = findViewById(R.id.imageButton29);
        imageButton.setOnClickListener(v -> {
            Intent back = new Intent(Webbrowser.this, Moreapps.class);
            startActivity(back);
            finish();
        });
        editText = findViewById(R.id.editText2);
        webView = findViewById(R.id.webView);
        button.setOnClickListener(view -> {
            String string = editText.getText().toString();
            webView.loadUrl(string);
        });
    }
}
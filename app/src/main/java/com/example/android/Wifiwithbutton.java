package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class Wifiwithbutton extends AppCompatActivity {
    Button button, button1;
    ImageButton imageButton;
    WifiManager wifiManager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifiwithbutton);
        button = findViewById(R.id.button30);
        button1 = findViewById(R.id.button31);
        imageButton = findViewById(R.id.imageButton19);
        wifiManager = (WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);
        button.setOnClickListener(view -> wifiManager.setWifiEnabled(true));
        button1.setOnClickListener(view -> wifiManager.setWifiEnabled(false));
        imageButton.setOnClickListener(v -> {
            Intent intent = new Intent(Wifiwithbutton.this, Wifi.class);
            startActivity(intent);
            finish();
        });
    }
}
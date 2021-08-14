package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ToggleButton;

public class Wifiwithtoggle extends AppCompatActivity {
    ToggleButton toggleButton;
    ImageButton imageButton;
    WifiManager wifiManager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifiwithtoggle);
        toggleButton = findViewById(R.id.toggleButton2);
        imageButton = findViewById(R.id.imageButton18);
        wifiManager = (WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);
        toggleButton.setOnCheckedChangeListener((compoundButton, b) -> {
            if(b)
            {
                wifiManager.setWifiEnabled(true);
            }
            else
            {
                wifiManager.setWifiEnabled(false);
            }
        });
        imageButton.setOnClickListener(v -> {
            Intent intent = new Intent(Wifiwithtoggle.this, Wifi.class);
            startActivity(intent);
            finish();

        });
    }
}
package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.ImageButton;

public class Wifiwithimage extends AppCompatActivity {
    ImageButton imageButton, imageButton1;
    WifiManager wifiManager;
    private boolean wifi = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifiwithimage);
        imageButton = findViewById(R.id.imageButton20);
        imageButton1 = findViewById(R.id.imageButton21);
        wifiManager = (WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);
        imageButton.setOnClickListener(view -> {
            if(!wifi){
                wifiManager.setWifiEnabled(true);
                wifi = true;
                imageButton.setImageResource(R.drawable.on);
            }
            else {
                wifiManager.setWifiEnabled(false);
                wifi = false;
                imageButton.setImageResource(R.drawable.off);
            }
        });

        imageButton1.setOnClickListener(v -> {
            Intent intent = new Intent(Wifiwithimage.this, Wifi.class);
            startActivity(intent);
            finish();
        });
    }
}
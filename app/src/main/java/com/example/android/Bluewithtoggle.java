package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ToggleButton;

public class Bluewithtoggle extends AppCompatActivity {
    ImageButton imageButton;
    ToggleButton toggleButton;
    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluewithtoggle);
        imageButton = findViewById(R.id.imageButton23);
        toggleButton = findViewById(R.id.toggleButton3);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        toggleButton.setOnCheckedChangeListener((compoundButton, b) -> {
            if(b)
            {
                bluetoothAdapter.enable();
            }
            else
            {
                bluetoothAdapter.disable();
            }
        });
        imageButton.setOnClickListener(v -> {
            Intent intent = new Intent(Bluewithtoggle.this, Bluetooth.class);
            startActivity(intent);
            finish();
        });
    }
}
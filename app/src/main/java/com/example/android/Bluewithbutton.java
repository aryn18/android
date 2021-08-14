package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class Bluewithbutton extends AppCompatActivity {
    Button button, button1;
    ImageButton imageButton;
    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluewithbutton);
        button = findViewById(R.id.button35);
        button1 = findViewById(R.id.button36);
        imageButton = findViewById(R.id.imageButton24);
        bluetoothAdapter =BluetoothAdapter.getDefaultAdapter();
        button.setOnClickListener(view -> bluetoothAdapter.enable());
        button1.setOnClickListener(view -> bluetoothAdapter.disable());
        imageButton.setOnClickListener(v -> {
            Intent intent = new Intent(Bluewithbutton.this, Bluetooth.class);
            startActivity(intent);
            finish();
        });
    }
}
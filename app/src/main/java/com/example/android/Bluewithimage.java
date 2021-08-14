package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class Bluewithimage extends AppCompatActivity {
    ImageButton imageButton, imageButton1;
    BluetoothAdapter bluetoothAdapter;
    private boolean blue = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluewithimage);
        imageButton = findViewById(R.id.imageButton25);
        imageButton1 = findViewById(R.id.imageButton26);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        imageButton.setOnClickListener(view -> {
            if(!blue){
                bluetoothAdapter.enable();
                blue=true;
                imageButton.setImageResource(R.drawable.on);
            }
            else {
                bluetoothAdapter.disable();
                blue = false;
                imageButton.setImageResource(R.drawable.off);
            }
        });
        imageButton1.setOnClickListener(v -> {
            Intent intent = new Intent(Bluewithimage.this, Bluetooth.class);
            startActivity(intent);
            finish();
        });
    }
}
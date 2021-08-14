package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Realtime extends AppCompatActivity {
    EditText editText, editText1, editText2, editText3;
    Button button;
    ImageButton imageButton;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realtime);
        editText = findViewById(R.id.editText5);
        editText1 = findViewById(R.id.editText6);
        editText2 = findViewById(R.id.editText7);
        editText3 = findViewById(R.id.editText8);
        button = findViewById(R.id.button72);
        imageButton = findViewById(R.id.imageButton33);
        firebaseDatabase = FirebaseDatabase.getInstance();
        button.setOnClickListener(v -> {
            databaseReference = firebaseDatabase.getReference("users");
            String s1 = editText.getText().toString();
            String s2 = editText1.getText().toString();
            String s3 = editText2.getText().toString();
            String s4 = editText3.getText().toString();
            if(s4.length() != 10)
            {
                Toast.makeText(Realtime.this, "enter valid phone", Toast.LENGTH_SHORT).show();
            }
            else {
                users users = new users(s1,s2,s3,s4);
                databaseReference.child(s4).setValue(users);  //to fix this value
                Toast.makeText(Realtime.this, "Database completed", Toast.LENGTH_SHORT).show();
            }

        });
        imageButton.setOnClickListener(view -> {
            Intent back = new Intent(Realtime.this, Moreapps.class);
            startActivity(back);
            finish();
        });
    }
}
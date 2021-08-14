package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Email extends AppCompatActivity {
    EditText editText, editText1;
    ImageButton imageButton;
    Button button,button1;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        imageButton = findViewById(R.id.imageButton36);
        imageButton.setOnClickListener(view -> {
            Intent back = new Intent(Email.this, MainActivity.class);
            startActivity(back);
            finish();
        });
        editText = findViewById(R.id.editText11);
        editText1 = findViewById(R.id.editText12);
        editText1.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
        button = findViewById(R.id.button77);
        button1= findViewById(R.id.button78);
        progressBar = findViewById(R.id.progressBar);
        firebaseAuth=FirebaseAuth.getInstance();

        button.setOnClickListener(v -> {
            String s1 = editText.getText().toString().trim();  //trim removes extra spaces from string
            String s2 = editText1.getText().toString();
            if(s1.isEmpty())
            {
                editText.setError("Fill username");
                return;
            }
            else
            {
                if(s2.isEmpty())
                {
                    editText1.setError("Fill password");
                    return;
                }
            }
            progressBar.setVisibility(View.VISIBLE);
            firebaseAuth.signInWithEmailAndPassword(s1,s2).addOnCompleteListener(task -> {
                if(task.isSuccessful())
                {
                    Toast.makeText(Email.this, "login done", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(Email.this , Appsmenu.class);
                    startActivity(intent);
                }

                else
                {
                    Toast.makeText(Email.this, "Mismatch", Toast.LENGTH_SHORT).show();
                    Intent intent1  = new Intent(Email.this , Email2.class);
                    startActivity(intent1);
                }
                finish();
            });
        });
        button1.setOnClickListener(v -> {
            Intent intent2  = new Intent(Email.this , Email2.class);
            startActivity(intent2);
            finish();
        });
    }
}
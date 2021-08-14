package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Email2 extends AppCompatActivity {
    EditText editText, editText1;
    Button button, button1;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email2);

        editText = findViewById(R.id.editText13);
        editText1 = findViewById(R.id.editText14);
        editText1.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
        button = findViewById(R.id.button79);
        button1= findViewById(R.id.button80);
        progressBar = findViewById(R.id.progressBar2);
        firebaseAuth = FirebaseAuth.getInstance();
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
            firebaseAuth.createUserWithEmailAndPassword(s1,s2).addOnCompleteListener(task -> {
                if(task.isSuccessful())
                {
                    Toast.makeText(Email2.this, "Registration dene", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(Email2.this , Email.class);
                    startActivity(intent);
                }

                else
                {
                    Toast.makeText(Email2.this, "User already exist", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                    Intent intent1 = new Intent(Email2.this , Email.class);
                    startActivity(intent1);
                }
                finish();

            });
        });
        button1.setOnClickListener(v -> {
            Intent intent2 = new Intent(Email2.this , Email.class);
            startActivity(intent2);
            finish();

        });
    }
}
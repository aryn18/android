package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Sign2 extends AppCompatActivity {
    ImageView imageView;
    Button button, button1;
    TextView textView;
    FirebaseAuth firebaseAuth ;
    GoogleSignInClient googleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign2);
        button1 = findViewById(R.id.button83);
        textView= findViewById(R.id.textView12);
        imageView= findViewById(R.id.imageView6);
        button= findViewById(R.id.button82);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser!=null)
        {
            Glide.with(Sign2.this).load(firebaseUser.getPhotoUrl()).into(imageView);
            textView.setText(firebaseUser.getDisplayName());
        }

        googleSignInClient = GoogleSignIn.getClient(Sign2.this , GoogleSignInOptions.DEFAULT_SIGN_IN);
        button.setOnClickListener(v -> googleSignInClient.signOut().addOnCompleteListener(task -> {
            if(task.isSuccessful())
            {
                Toast.makeText(Sign2.this, "Logout done", Toast.LENGTH_SHORT).show();
                firebaseAuth.signOut();
                finish();
            }
        }));
        button1.setOnClickListener(view -> {
            Intent intent = new Intent(Sign2.this, Appsmenu.class);
            startActivity(intent);
            finish();
        });
    }
}
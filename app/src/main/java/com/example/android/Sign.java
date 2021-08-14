package com.example.android;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class Sign extends AppCompatActivity {
    SignInButton signInButton ;
    GoogleSignInClient googleSignInClient; // to pick google account
    FirebaseAuth firebaseAuth;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        imageButton = findViewById(R.id.imageButton34);
        imageButton.setOnClickListener(view -> {
            Intent intent = new Intent(Sign.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
        signInButton = findViewById(R.id.signin);
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken("59893454723-n4976tarlapd5uo2n2kp50ahrlgjc7bs.apps.googleusercontent.com").requestEmail().build(); //it picks the email id given by the user and sends it ot user for verification
        googleSignInClient = GoogleSignIn.getClient(Sign.this , googleSignInOptions); // gmail pe  login karake verify karake store kata lai
        signInButton.setOnClickListener(v -> {
            Intent i = googleSignInClient.getSignInIntent();
            startActivityForResult(i , 100);
        });

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser!=null)
        {
            Intent i = new Intent(Sign.this , Sign2.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //flag se wpo back jane pe dobara login nhi karna pdega
            startActivity(i);
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100)
        {
            Task<GoogleSignInAccount> signInAccountTask = GoogleSignIn.getSignedInAccountFromIntent(data);
            if(signInAccountTask.isSuccessful())
            {
                Toast.makeText(this, "sign in successful", Toast.LENGTH_SHORT).show();
                try {
                    GoogleSignInAccount googleSignInAccount = signInAccountTask.getResult(ApiException.class);
                    if(googleSignInAccount != null)
                    {
                        AuthCredential authCredential = GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(),null);
                        firebaseAuth.signInWithCredential(authCredential).addOnCompleteListener(task -> {

                            if(task.isSuccessful())
                            {
                                Toast.makeText(Sign.this, "firebase database updated", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(Sign.this , Sign2.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(i);
                            }
                            else
                            {
                                Toast.makeText(Sign.this, "database updated", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
                catch (ApiException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
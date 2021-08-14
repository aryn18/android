package com.example.android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class Otp2 extends AppCompatActivity {
    EditText editText;
    String phone ;
    Button button;
    String otp ;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp2);
        phone = getIntent().getStringExtra("mobile").toString();
        editText=findViewById(R.id.editText10);
        button=findViewById(R.id.button74);
        firebaseAuth = FirebaseAuth.getInstance();

        genotp();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().isEmpty())
                {
                    Toast.makeText(Otp2.this, "Pls Enter OTP", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    if(editText.getText().toString().length()!=6)
                    {
                        Toast.makeText(Otp2.this, "Invalid OTP", Toast.LENGTH_SHORT).show();
                    }

                    else
                    {
                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(otp , editText.getText().toString());
                        signInWithPhoneAuthcredential(credential);
                    }
                }
            }
        });
    }
    private void genotp()
    {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone, 60, TimeUnit.SECONDS, this, new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(@NonNull @NotNull String s, @NonNull @NotNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);
                        otp = s;
                    }

                    @Override
                    public void onVerificationCompleted(@NonNull @org.jetbrains.annotations.NotNull PhoneAuthCredential phoneAuthCredential) {
                        signInWithPhoneAuthcredential(phoneAuthCredential);
                    }

                    @Override
                    public void onVerificationFailed(@NonNull @org.jetbrains.annotations.NotNull FirebaseException e) {
                        Toast.makeText(Otp2.this, "OTP mismatched", Toast.LENGTH_SHORT).show();

                    }
                }
        );
    }

    private void signInWithPhoneAuthcredential(PhoneAuthCredential credential)
    {
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(Otp2.this, "Login done", Toast.LENGTH_SHORT).show();
                    Intent j = new Intent(Otp2.this , Appsmenu.class);
                    startActivity(j);
                    finish();
                }
                else
                {
                    Toast.makeText(Otp2.this, "Not done", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
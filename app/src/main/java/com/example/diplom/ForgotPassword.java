package com.example.diplom;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        mAuth = FirebaseAuth.getInstance();
    }

    public void tvlog(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }

    public void recoveryPass(View view) {
        recoveryPasswordWithEmail();
    }

    private void recoveryPasswordWithEmail() {
        EditText email = findViewById(R.id.emailRecovery);
        String userEmail = email.getText().toString();
        if (TextUtils.isEmpty(userEmail)) {
            Toast.makeText(this, "Введите вашу почту!", Toast.LENGTH_SHORT).show();
        } else {
            mAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(ForgotPassword.this, "Пожалуйста проверьте свою почту, для смены пароля", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ForgotPassword.this, Login.class));
                        finish();
                    } else {
                        String message = task.getException().getMessage();
                        Toast.makeText(ForgotPassword.this, "Произошла ошибка: Проверьте правильность вашей почты ", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}


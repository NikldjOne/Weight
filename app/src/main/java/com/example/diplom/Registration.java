package com.example.diplom;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.diplom.models.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Registration extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseDatabase db;
    private DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_main);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }

    private void showRegisterWindow() {
        final EditText email = findViewById(R.id.tiEmail);
        final EditText pass = findViewById(R.id.text_input_password);
        final String email_2 = email.getText().toString();
        final String pass_2 = pass.getText().toString();
        if (TextUtils.isEmpty(email_2)) {
            Toast.makeText(this, "Введите вашу почту!", Toast.LENGTH_LONG).show();
        } else if (pass_2.length() < 6) {
            Toast.makeText(this, "Введите пароль, который больше 6 символов", Toast.LENGTH_LONG).show();
        } else {

            mAuth.createUserWithEmailAndPassword(email_2, pass_2)
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            User user = new User();
                            user.setEmail(email_2);
                            user.setPassword(pass_2);
                            users.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Toast.makeText(Registration.this, "Пользователь создан!", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Registration.this, "Ошибка регистрации: Проверьте правильность почты", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    public void tvpol(View view) {
        Intent intent = new Intent(this, Politika.class);
        startActivity(intent);
    }

    public void tvkonf(View view) {
        konf();
    }

    public void tvkonf2(View view) {
        konf();
    }

    public void konf() {
        Intent intent = new Intent(this, Konfidentional.class);
        startActivity(intent);
    }

    public void regClick(View view) {
        showRegisterWindow();
    }
}

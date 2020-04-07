package com.example.diplom;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseDatabase db;
    private DatabaseReference users;
    Button btnSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnSignIn = findViewById(R.id.btnSignIn);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");
        btnSignIn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
showSignInWindow();
    }
});
    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void showSignInWindow() {
        final EditText email = findViewById(R.id.tiEmaillog);
        final EditText pass = findViewById(R.id.text_input_password_log);
        if(TextUtils.isEmpty(email.getText().toString())){
            Toast.makeText(this, "Введите вашу почту!", Toast.LENGTH_LONG).show();
            return;
        }
        if(pass.getText().toString().length()<6){
            Toast.makeText(this, "Введите пароль, который больше 6 символов", Toast.LENGTH_LONG).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(email.getText().toString(),pass.getText().toString())
        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                startActivity(new Intent(Login.this,Main2Activity.class));
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Login.this, "Ошибка авторизации,проверьте данные", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void politikaShow(){
        Intent intent = new Intent(this, Politika.class);
        startActivity(intent);
    }

    public void tvPass(View view) {
        Intent intent = new Intent(this, ForgotPassword.class);
        startActivity(intent);
    }


    public void tvpol2(View view) {
        politikaShow();
    }

    public void tvpol(View view) {
        politikaShow();
    }

    public void konf(View view) {
        Intent intent = new Intent(this, Konfidentional.class);
        startActivity(intent);
    }

}

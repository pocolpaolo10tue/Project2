package com.example.project2;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    Button RegisterButton;
    Button LoginButton;
    EditText InputEmail;
    EditText InputPassword;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        RegisterButton = findViewById(R.id.register);
        LoginButton = findViewById(R.id.login);
        InputEmail = findViewById(R.id.username);
        InputPassword = findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();

        RegisterButton.setOnClickListener(view ->{
            Register();
        });
        LoginButton.setOnClickListener(view ->{
            Login();
        });
    }

    private void Register() {
        System.out.println("hoi");
        String email = InputEmail.getText().toString().trim();
        String password = InputPassword.getText().toString().trim();
//        Boolean tuemail = email.substring(email.length()-6) == "tue.nl";
        if (TextUtils.isEmpty(email)) {
            InputEmail.setError("Email cannot be empty");
            InputEmail.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            InputPassword.setError("Password cannot be empty");
            InputPassword.requestFocus();
        } else if (password.length() <= 5) {
            InputPassword.setError("Password has to be atleast 5 characters");
            InputPassword.requestFocus();
        } else {
            mAuth.createUserWithEmailAndPassword(email, password).
                    addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(LoginActivity.this,
                                "Account Created", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "Error: " +
                                task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void Login() {
        String email = InputEmail.getText().toString().trim();
        String password = InputPassword.getText().toString().trim();
//        Boolean tuemail = email.substring(email.length()-6) == "tue.nl";
        if (TextUtils.isEmpty(email)) {
            InputEmail.setError("Please enter a valid tu/e email");
            InputEmail.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            InputPassword.setError("Password cannot be empty");
            InputPassword.requestFocus();
        } else if (password.length() <= 5) {
            InputPassword.setError("Password has to be atleast 5 characters");
            InputPassword.requestFocus();
        } else {
            mAuth.signInWithEmailAndPassword(email, password).
                    addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this,
                                        "User Logged in", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(LoginActivity.this, "Error: " +
                                        task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}

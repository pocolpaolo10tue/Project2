package com.example.project2.data;

import androidx.annotation.NonNull;

import com.example.project2.data.model.LoggedInUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {
    private FirebaseAuth mAuth;

    public Result<LoggedInUser> login(String username, String password) {
        mAuth = FirebaseAuth.getInstance();
        try {
            LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe");
            return new Result.Success<>(fakeUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        mAuth.signOut();
        // TODO: Message about logging out
        // TODO: Move User to different page
    }

    public void Login(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            // TODO: Send message to user for login
                            // TODO: Move user to different tab
                        } else {
                            // TODO: Login Error
                        }
                    }
                });

    }
    public void Register(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    // TODO: Send message to user for register
                    // TODO: Move user to different tab
                } else {
                    // TODO: Registration Error
                }
            }
        });
    }
}
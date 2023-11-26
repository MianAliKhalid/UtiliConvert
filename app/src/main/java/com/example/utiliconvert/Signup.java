package com.example.utiliconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Signup extends AppCompatActivity {

    TextInputLayout fullname, username, email, phonenumber, password;

    Button already_acc, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup);

        username = findViewById(R.id.username);
        fullname = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phonenumber = findViewById(R.id.phnumber);
        password = findViewById(R.id.password);
        already_acc = findViewById(R.id.already_acc);
        signup = findViewById(R.id.signup_submit);

        final String user = "admin";

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredUsername = username.getEditText().getText().toString();
                if (enteredUsername.equals(user)) {
                    Toast.makeText(Signup.this, "Account Already Exists! Login or Click to Forget", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(Signup.this, Login.class);
                startActivity(intent);
                finish();

            }
        });


        already_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Signup.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

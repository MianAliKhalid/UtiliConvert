package com.example.utiliconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    TextInputLayout username, password;
    Button gofor_login,call_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        gofor_login = findViewById(R.id.gofor_login);
        call_signup = findViewById(R.id.call_signup);

        call_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Login.this,"Add your Details",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Login.this, Signup.class);
                startActivity(intent);
                finish();

            }
        });

        gofor_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Login.this,"Login Sucessfully",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Login.this, Gridview.class);
                startActivity(intent);
                finish();

            }
        });







    }
}
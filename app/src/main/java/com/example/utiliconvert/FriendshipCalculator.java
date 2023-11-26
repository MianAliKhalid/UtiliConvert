package com.example.utiliconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class FriendshipCalculator extends AppCompatActivity {


        private TextInputLayout editTextName1,editTextName2;
        private Button calculateButton;
        private TextView resultTextView;
        private ImageView appLogo;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

            setContentView(R.layout.activity_friendship_calculator);

            editTextName1 = findViewById(R.id.editTextName1);
            editTextName2 = findViewById(R.id.editTextName2);
            calculateButton = findViewById(R.id.calculateButton);
            resultTextView = findViewById(R.id.resultTextView);
            appLogo = findViewById(R.id.image_logo);

            calculateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    calculateFriendshipScore();
                    startBlinkingAnimation();
                }
            });
        }

        private void calculateFriendshipScore() {

            String name1 = editTextName1.getEditText().getText().toString();
            String name2 = editTextName2.getEditText().getText().toString();



            int score = calculateScore(name1, name2);


            String resultMessage = "Friendship Score: " + score;
            resultTextView.setText(resultMessage);
        }

        private int calculateScore(String name1, String name2) {

            int score = 0;
            for (int i = 0; i < name1.length(); i++) {
                score += name1.charAt(i);
            }
            for (int i = 0; i < name2.length(); i++) {
                score += name2.charAt(i);
            }
            return score % 101;
        }

        private void startBlinkingAnimation() {
            Animation blinkAnimation = AnimationUtils.loadAnimation(this, R.anim.blink);
            appLogo.startAnimation(blinkAnimation);
        }
    }

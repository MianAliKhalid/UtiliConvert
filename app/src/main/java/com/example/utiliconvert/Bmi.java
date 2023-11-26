package com.example.utiliconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Bmi extends AppCompatActivity {


        private EditText ageEditText;

        private RadioGroup genderRadioGroup;
        private EditText heightEditText;
        private EditText weightEditText;
        private Button submitButton;
        private TextView bmiResultsTextView;
        private ImageView bmiLogoImageView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_bmi);

            ageEditText = findViewById(R.id.ageEditText);
            genderRadioGroup = findViewById(R.id.genderRadioGroup);
            heightEditText = findViewById(R.id.heightEditText);
            weightEditText = findViewById(R.id.weightEditText);
            submitButton = findViewById(R.id.submitButton);
            bmiResultsTextView = findViewById(R.id.bmiResultsTextView);
            bmiLogoImageView = findViewById(R.id.bmiLogoImageView);

            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    calculateBMI();
                    startLogoAnimation();
                }
            });
        }

        private void calculateBMI() {
            int age = Integer.parseInt(ageEditText.getText().toString());
            int genderId = genderRadioGroup.getCheckedRadioButtonId();
            String height = heightEditText.getText().toString();
            double weight = Double.parseDouble(weightEditText.getText().toString());

            double bmi = calculateBMIValue(height, weight);
            String resultMessage = "BMI: " + bmi;
            bmiResultsTextView.setText(resultMessage);
        }

        private double calculateBMIValue(String height, double weight) {

            try {
                double heightInMeters = feetAndInchesToMeters(height);
                return weight / (heightInMeters * heightInMeters);
            } catch (NumberFormatException e) {

                return 0.0;
            }
        }

        private double feetAndInchesToMeters(String height) {
            String[] parts = height.split("'");
            int feet = Integer.parseInt(parts[0]);
            int inches = Integer.parseInt(parts[1].replace("\"", ""));
            double totalInches = (feet * 12) + inches;
            return totalInches * 0.0254; // Convert to meters
        }

        private void startLogoAnimation() {
            Animation shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);

            bmiLogoImageView.startAnimation(shakeAnimation);
        }
    }

package com.example.utiliconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CurrencyConverterActivity extends AppCompatActivity {


        private EditText editTextAmount;
        private Button convertToDollarButton;
        private Button convertToPKRButton;
        private TextView resultTextView;
        private ImageView appLogo;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_currency_converter);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

            editTextAmount = findViewById(R.id.editTextAmount);
            convertToDollarButton = findViewById(R.id.convertToDollarButton);
            convertToPKRButton = findViewById(R.id.convertToPKRButton);
            resultTextView = findViewById(R.id.resultTextView);
            appLogo = findViewById(R.id.appLogo);


            convertToDollarButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    convertToDollar();
                }
            });

            convertToPKRButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    convertToPKR();
                }
            });
        }

        private void convertToDollar() {
            double amount = Double.parseDouble(editTextAmount.getText().toString());
            double convertedAmount = amount / 300; // 1 Dollar = 300 PKR
            String result = String.format("%.2f", convertedAmount) + " Dollars";
            resultTextView.setText(result);


            startLogoAnimation();
        }

        private void convertToPKR() {
            double amount = Double.parseDouble(editTextAmount.getText().toString());
            double convertedAmount = amount * 300; // 1 Dollar = 300 PKR
            String result = String.format("%.2f", convertedAmount) + " PKR";
            resultTextView.setText(result);

            
            startLogoAnimation();
        }

        private void startLogoAnimation() {
            Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate1);
            appLogo.startAnimation(rotateAnimation);
        }
    }

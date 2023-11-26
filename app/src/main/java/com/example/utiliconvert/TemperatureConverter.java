package com.example.utiliconvert;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TemperatureConverter extends AppCompatActivity {



        private EditText editTextInput;
        private Button buttonConvert;
        private TextView textViewResult;
        private ImageView appLogo;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_temperature_converter);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

            editTextInput = findViewById(R.id.editTextInput);
            buttonConvert = findViewById(R.id.buttonConvert);
            textViewResult = findViewById(R.id.textViewResult);
            appLogo = findViewById(R.id.appLogo);

            buttonConvert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startAnimatingLogo();
                    convertTemperature();
                }
            });
        }

        private void startAnimatingLogo() {
            Animation shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);
            appLogo.startAnimation(shakeAnimation);
        }

    private void convertTemperature() {
        String inputText = editTextInput.getText().toString();
        if (!inputText.isEmpty()) {
            try {
                double inputValue = Double.parseDouble(inputText);

                double result = (inputValue * 9 / 5) + 32;

                String resultMessage = "Result: " + result + "F";
                textViewResult.setText(resultMessage);
            } catch (NumberFormatException e) {

                textViewResult.setText("Invalid input. Please enter a valid temperature.");
            }
        } else {
            textViewResult.setText("Please enter a temperature.");
        }
    }

}

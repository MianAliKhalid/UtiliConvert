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

public class AreaConverter extends AppCompatActivity {

    private TextInputLayout metersInputLayout;
    private EditText metersEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        metersInputLayout = findViewById(R.id.metersInputLayout);
        metersEditText = findViewById(R.id.metersEditText);
        resultTextView = findViewById(R.id.resultTextView);
    }

    public void convert(View view) {
        String metersStr = metersEditText.getText().toString().trim();

        if (metersStr.isEmpty()) {
            metersInputLayout.setError("Enter a value");
            return;
        } else {
            metersInputLayout.setError(null);
        }

        double meters = Double.parseDouble(metersStr);
        double squareFeet = meters * 10.7639; // Conversion factor

        resultTextView.setText(String.format("%.2f square feet", squareFeet));
    }
}
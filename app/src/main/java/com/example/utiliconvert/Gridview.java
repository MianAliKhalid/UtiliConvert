package com.example.utiliconvert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class Gridview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final CardView card1 = findViewById(R.id.card1);
        final CardView card2 = findViewById(R.id.card2);
        final CardView card3 = findViewById(R.id.card3);
        final CardView card4 = findViewById(R.id.card4);
        final CardView card5 = findViewById(R.id.card5);
        final CardView card10 = findViewById(R.id.card10);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gridview.this, FriendshipCalculator.class);
                startActivity(intent);
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gridview.this, CurrencyConverterActivity.class);
                startActivity(intent);
            }
        });


            card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start Friendship Calculator Activity
                Intent intent = new Intent(Gridview.this, TemperatureConverter.class);
                startActivity(intent);
            }
        });
            card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start Friendship Calculator Activity
                Intent intent = new Intent(Gridview.this, Bmi.class);
                startActivity(intent);
            }
        });

            card10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start Friendship Calculator Activity
                Intent intent = new Intent(Gridview.this, AgeCalculator.class);
                startActivity(intent);
            }
        });
            card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start Friendship Calculator Activity
                Intent intent = new Intent(Gridview.this, AreaConverter.class);
                startActivity(intent);
            }
        });



    }
}
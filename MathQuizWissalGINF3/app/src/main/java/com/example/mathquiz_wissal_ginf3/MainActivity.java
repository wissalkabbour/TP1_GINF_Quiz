package com.example.mathquiz_wissal_ginf3; // <-- keep whatever Android Studio generated

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tvNumber1, tvNumber2, tvResult;
    private Button btnAdd, btnSub, btnMul, btnGenerate;
    private int number1, number2;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Random
        random = new Random();

        // Link views with IDs from XML
        tvNumber1 = findViewById(R.id.tvNumber1);
        tvNumber2 = findViewById(R.id.tvNumber2);
        tvResult = findViewById(R.id.tvResult);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnGenerate = findViewById(R.id.btnGenerate);

        // Generate first pair of random numbers
        generateNumbers();

        // + button
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = number1 + number2;
                tvResult.setText(String.valueOf(result));
            }
        });

        // - button
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = number1 - number2;
                tvResult.setText(String.valueOf(result));
            }
        });

        // × button
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = number1 * number2;
                tvResult.setText(String.valueOf(result));
            }
        });

        // Générer button -> new random numbers and reset result
        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNumbers();
                tvResult.setText("---");
            }
        });
    }

    /**
     * Generates two random integers between 111 and 999 (inclusive)
     * and displays them.
     */
    private void generateNumbers() {
        // max - min + 1 = 999 - 111 + 1 = 889 possible values
        number1 = random.nextInt(889) + 111;
        number2 = random.nextInt(889) + 111;

        tvNumber1.setText(String.valueOf(number1));
        tvNumber2.setText(String.valueOf(number2));
    }
}

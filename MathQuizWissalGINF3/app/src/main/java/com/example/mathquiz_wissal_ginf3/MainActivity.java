package com.example.mathquiz_wissal_ginf3; // <-- garde ici ton vrai package

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tvNumber1, tvNumber2, tvResult;
    private EditText etAnswer;
    private Button btnAdd, btnSub, btnMul, btnGenerate;
    private int number1, number2;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init Random
        random = new Random();

        // Link views
        tvNumber1 = findViewById(R.id.tvNumber1);
        tvNumber2 = findViewById(R.id.tvNumber2);
        tvResult  = findViewById(R.id.tvResult);

        etAnswer  = findViewById(R.id.etAnswer);

        btnAdd      = findViewById(R.id.btnAdd);
        btnSub      = findViewById(R.id.btnSub);
        btnMul      = findViewById(R.id.btnMul);
        btnGenerate = findViewById(R.id.btnGenerate);

        // First question
        generateNumbers();

        // + button : check user's answer for addition
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer('+');
            }
        });

        // - button : check user's answer for subtraction
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer('-');
            }
        });

        // × button : check user's answer for multiplication
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer('*');
            }
        });

        // Générer : new numbers, clear answer & result
        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNumbers();
                etAnswer.setText("");
                tvResult.setText("---");
            }
        });
    }

    // Generate two random numbers between 111 and 999
    private void generateNumbers() {
        number1 = random.nextInt(889) + 111; // 111..999
        number2 = random.nextInt(889) + 111;

        tvNumber1.setText(String.valueOf(number1));
        tvNumber2.setText(String.valueOf(number2));
    }

    // Check user's answer depending on operation
    private void checkAnswer(char operation) {
        String answerText = etAnswer.getText().toString().trim();

        if (answerText.isEmpty()) {
            tvResult.setText("Veuillez entrer une réponse.");
            return;
        }

        int userAnswer;
        try {
            userAnswer = Integer.parseInt(answerText);
        } catch (NumberFormatException e) {
            tvResult.setText("Réponse invalide (entrez un nombre entier).");
            return;
        }

        int correctAnswer;

        switch (operation) {
            case '+':
                correctAnswer = number1 + number2;
                break;
            case '-':
                correctAnswer = number1 - number2;
                break;
            case '*':
                correctAnswer = number1 * number2;
                break;
            default:
                tvResult.setText("Opération inconnue.");
                return;
        }

        if (userAnswer == correctAnswer) {
            tvResult.setText("Bonne réponse !");
        } else {
            tvResult.setText("Mauvaise réponse. La bonne réponse est : " + correctAnswer);
        }
    }
}

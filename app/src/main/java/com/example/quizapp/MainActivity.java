package com.example.quizapp;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout javaButton, htmlButton, javascriptButton, sqlButton, generalButton;
    Button achievementsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        javaButton = findViewById(R.id.javaButton);
        htmlButton = findViewById(R.id.htmlButton);
        javascriptButton = findViewById(R.id.javascriptButton);
        sqlButton = findViewById(R.id.sqlButton);
        generalButton = findViewById(R.id.generalButton);
        achievementsButton = findViewById(R.id.achievementsButton);

        achievementsButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AchievementsActivity.class);
            startActivity(intent);
        });

        javaButton.setOnClickListener(v -> openQuiz("Java"));
        htmlButton.setOnClickListener(v -> openQuiz("HTML & CSS"));
        javascriptButton.setOnClickListener(v -> openQuiz("JavaScript"));
        sqlButton.setOnClickListener(v -> openQuiz("SQL & DBMS"));
        generalButton.setOnClickListener(v -> openQuiz("Computer Basics"));
    }

    private void openQuiz(String category) {
        Intent intent = new Intent(MainActivity.this, QuizActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }
}
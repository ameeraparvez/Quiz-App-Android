package com.example.quizapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView resultCategory, scoreText, scoreMessage, achievementText;
    ImageView badgeImage;
    Button restartButton, homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultCategory = findViewById(R.id.resultCategory);
        scoreText = findViewById(R.id.scoreText);
        scoreMessage = findViewById(R.id.scoreMessage);
        achievementText = findViewById(R.id.achievementText);
        badgeImage = findViewById(R.id.badgeImage);
        restartButton = findViewById(R.id.restartButton);
        homeButton = findViewById(R.id.homeButton);

        String category = getIntent().getStringExtra("category");
        int score = getIntent().getIntExtra("score", 0);
        int total = getIntent().getIntExtra("total", 0);

        resultCategory.setText(category + " Quiz");
        scoreText.setText(score + " / " + total);

        SharedPreferences preferences =
                getSharedPreferences("QuizAchievements", MODE_PRIVATE);

        int highestScore = preferences.getInt("highestScore", 0);

        if (score > highestScore) {
            preferences.edit()
                    .putInt("highestScore", score)
                    .apply();
        }

        double percentage = total > 0
                ? ((double) score / total) * 100
                : 0;

        if (percentage >= 90) {
            scoreMessage.setText("Outstanding! You're a Quiz Master!");
            achievementText.setText("🏆 QUIZ MASTER");
            badgeImage.setImageResource(R.drawable.dia);

        } else if (percentage >= 80) {
            scoreMessage.setText("Excellent! Great job!");
            achievementText.setText("🥇 GOLD MEDALIST");
            badgeImage.setImageResource(R.drawable.gold);

        } else if (percentage >= 60) {
            scoreMessage.setText("Good job! Keep it up.");
            achievementText.setText("🥈 SILVER MEDALIST");
            badgeImage.setImageResource(R.drawable.silver);

        } else if (percentage >= 40) {
            scoreMessage.setText("Nice try! You passed.");
            achievementText.setText("🥉 BRONZE MEDALIST");
            badgeImage.setImageResource(R.drawable.bronze);

        } else {
            scoreMessage.setText("Don't give up! Try again.");
            achievementText.setText("🔰 BEGINNER");
            badgeImage.setImageResource(R.drawable.beginner);
        }

        restartButton.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, QuizActivity.class);
            intent.putExtra("category", category);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });

        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });
    }
}
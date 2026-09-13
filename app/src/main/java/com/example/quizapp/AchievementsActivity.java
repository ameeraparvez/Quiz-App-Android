package com.example.quizapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AchievementsActivity extends AppCompatActivity {

    ImageButton backButton;

    ImageView diamondBadge, goldBadge, silverBadge, bronzeBadge, beginnerBadge;

    TextView diamondText, goldText, silverText, bronzeText, beginnerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);

        backButton = findViewById(R.id.backButton);

        diamondBadge = findViewById(R.id.diamondBadge);
        goldBadge = findViewById(R.id.goldBadge);
        silverBadge = findViewById(R.id.silverBadge);
        bronzeBadge = findViewById(R.id.bronzeBadge);
        beginnerBadge = findViewById(R.id.beginnerBadge);

        diamondText = findViewById(R.id.diamondText);
        goldText = findViewById(R.id.goldText);
        silverText = findViewById(R.id.silverText);
        bronzeText = findViewById(R.id.bronzeText);
        beginnerText = findViewById(R.id.beginnerText);

        SharedPreferences preferences =
                getSharedPreferences("QuizAchievements", MODE_PRIVATE);

        int score = preferences.getInt("highestScore", 0);

        showAchievement(score);

        backButton.setOnClickListener(v -> finish());
    }

    private void showAchievement(int score) {

        diamondBadge.setAlpha(0.35f);
        goldBadge.setAlpha(0.35f);
        silverBadge.setAlpha(0.35f);
        bronzeBadge.setAlpha(0.35f);
        beginnerBadge.setAlpha(0.35f);

        diamondText.setAlpha(0.5f);
        goldText.setAlpha(0.5f);
        silverText.setAlpha(0.5f);
        bronzeText.setAlpha(0.5f);
        beginnerText.setAlpha(0.5f);

        if (score >= 10) {

            diamondBadge.setAlpha(1f);
            diamondText.setAlpha(1f);

        } else if (score >= 8) {

            goldBadge.setAlpha(1f);
            goldText.setAlpha(1f);

        } else if (score >= 6) {

            silverBadge.setAlpha(1f);
            silverText.setAlpha(1f);

        } else if (score >= 4) {

            bronzeBadge.setAlpha(1f);
            bronzeText.setAlpha(1f);

        } else if (score >= 1) {

            beginnerBadge.setAlpha(1f);
            beginnerText.setAlpha(1f);
        }
    }
}
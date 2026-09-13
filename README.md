# Quiz App - Android

A feature-rich Android Quiz App developed using Java and XML in Android Studio. The application allows users to test their knowledge through multiple categories with timed questions, randomized options, score tracking, explanations, and achievement badges.

## Features

- Splash screen
- 5 quiz categories
- 10 questions per category
- 50 questions in total
- Randomized answer options
- 15-second countdown timer
- Two attempts for each question
- Correct and wrong answer highlighting
- Explanation after answering
- Progress bar
- Automatic score calculation
- Result screen with percentage-based achievements
- Achievement badges
- Retry quiz option
- Home navigation
- Clean and modern dark-themed UI

## Quiz Categories

1. Java
2. HTML & CSS
3. JavaScript
4. SQL & DBMS
5. Computer Basics

## Technology Used

- Java
- XML
- Android Studio
- Android SDK
- SharedPreferences

## App Flow

Splash Screen → Category Selection → Quiz Questions → Result → Achievements / Retry

## How It Works

Users first select a quiz category from the home screen. Each category contains 10 multiple-choice questions. Every question has a 15-second timer and allows two attempts.

The application provides visual feedback for correct and incorrect answers. After a question is completed, an explanation is displayed to help users understand the answer.

At the end of the quiz, the user's score and achievement level are displayed on the result screen.

## Achievement Levels

- Quiz Master
- Gold Medalist
- Silver Medalist
- Bronze Medalist
- Beginner

## Project Purpose

The main purpose of this project is to create an interactive learning application while practicing Android application development, Java programming, XML layouts, UI design, event handling, timers, navigation, and score management.

## Future Improvements

- Add more quiz categories
- Add more questions
- Store category-wise scores
- Add user profiles
- Add a leaderboard
- Add online question database
- Add sound effects and animations

## Project structure
QuizApp/
│
├── .gradle/
├── .idea/
├── app/
│   ├── build/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/
│   │       │       └── example/
│   │       │           └── quizapp/
│   │       │               ├── MainActivity.java
│   │       │               ├── QuizActivity.java
│   │       │               ├── ResultActivity.java
│   │       │               ├── AchievementsActivity.java
│   │       │               └── SplashActivity.java
│   │       │
│   │       ├── res/
│   │       │   ├── drawable/
│   │       │   │   ├── category_card_background.xml
│   │       │   │   ├── option_background.xml
│   │       │   │   ├── correct_answer.xml
│   │       │   │   ├── wrong_answer.xml
│   │       │   │   ├── explanation_background.xml
│   │       │   │   └── app icons/images
│   │       │   │
│   │       │   ├── layout/
│   │       │   │   ├── activity_main.xml
│   │       │   │   ├── activity_quiz.xml
│   │       │   │   ├── activity_result.xml
│   │       │   │   ├── activity_achievements.xml
│   │       │   │   └── activity_splash.xml
│   │       │   │
│   │       │   ├── mipmap/
│   │       │   ├── values/
│   │       │   │   ├── colors.xml
│   │       │   │   ├── strings.xml
│   │       │   │   └── themes.xml
│   │       │   └── ...
│   │       │
│   │       └── AndroidManifest.xml
│   │
│   ├── build.gradle
│   └── proguard-rules.pro
│
├── build.gradle
├── gradle.properties
├── settings.gradle
└── gradlew

## Developer

**Ameera Parvez**

BCA Student | Aspiring Web Developer | Android App Developer

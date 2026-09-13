package com.example.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class QuizActivity extends AppCompatActivity {

    TextView categoryTitle, questionNumber, questionText, timerText;
    TextView explanationText;
    RadioGroup optionsGroup;
    RadioButton option1, option2, option3, option4;
    RadioButton wrongOption;
    Button nextButton;
    ProgressBar quizProgress;

    CountDownTimer countDownTimer;

    String category;
    int currentQuestion = 0;
    int score = 0;
    int attempts = 0;

    String[][] questions = {
            {"Which keyword is used to create a class in Java?", "class", "Class", "new", "object", "class", "The class keyword is used to define a class in Java."},
            {"Which method is the starting point of a Java program?", "start()", "main()", "run()", "begin()", "main()", "The main() method is the entry point from where a Java application starts executing."},
            {"Which concept allows one class to acquire properties of another?", "Encapsulation", "Inheritance", "Polymorphism", "Abstraction", "Inheritance", "Inheritance allows a class to acquire properties and methods from another class."},
            {"Which data type is used to store true or false?", "int", "boolean", "char", "String", "boolean", "The boolean data type stores only two values: true or false."},
            {"Which keyword is used to inherit a class in Java?", "implements", "extends", "inherits", "super", "extends", "The extends keyword is used when one class inherits another class."},
            {"Which keyword is used to create an object in Java?", "class", "new", "this", "object", "new", "The new keyword creates a new object of a class."},
            {"Which symbol is used to end a statement in Java?", ".", ":", ";", ",", ";", "The semicolon is used to terminate most statements in Java."},
            {"Which keyword is used to define a constant in Java?", "final", "static", "constant", "const", "final", "The final keyword prevents a variable from being reassigned after it is initialized."},
            {"Which OOP concept means hiding data and methods inside a class?", "Inheritance", "Encapsulation", "Polymorphism", "Abstraction", "Encapsulation", "Encapsulation combines data and methods inside a class and controls access to the data."},
            {"Which keyword is used to handle exceptions?", "error", "try", "catching", "exception", "try", "The try keyword is used to define a block of code that may throw an exception."}
    };

    String[][] htmlQuestions = {
            {"What does HTML stand for?", "Hyper Text Markup Language", "High Text Machine Language", "Hyper Tool Markup Language", "Home Text Markup Language", "Hyper Text Markup Language", "HTML stands for Hyper Text Markup Language and is used to structure web pages."},
            {"Which tag is used to create a paragraph?", "<p>", "<para>", "<text>", "<paragraph>", "<p>", "The <p> tag is used to define a paragraph in HTML."},
            {"Which CSS property changes text color?", "font-color", "text-color", "color", "background-color", "color", "The color property is used to change the color of text in CSS."},
            {"Which HTML tag is used to create a hyperlink?", "<link>", "<a>", "<href>", "<url>", "<a>", "The <a> tag creates hyperlinks that allow users to navigate to another page or resource."},
            {"Which CSS property is used to change the background color?", "color", "background-color", "bgcolor", "background", "background-color", "The background-color property sets the background color of an HTML element."},
            {"Which HTML tag is used to display an image?", "<image>", "<img>", "<picture>", "<src>", "<img>", "The <img> tag is used to display an image on a web page."},
            {"Which HTML tag is used to create an unordered list?", "<ol>", "<ul>", "<li>", "<list>", "<ul>", "The <ul> tag creates an unordered list, while each item is usually placed inside an <li> tag."},
            {"Which CSS property is used to change the font size?", "text-size", "font-size", "font-style", "font-weight", "font-size", "The font-size property controls the size of text in CSS."},
            {"Which HTML element is used for the largest heading?", "<h6>", "<head>", "<h1>", "<heading>", "<h1>", "The <h1> element represents the largest and most important heading level in HTML."},
            {"Which CSS property is used to make text bold?", "font-style", "font-weight", "text-bold", "font-bold", "font-weight", "The font-weight property controls the thickness of text, including bold text."}
    };

    String[][] javascriptQuestions = {
            {"Which keyword is used to declare a variable in JavaScript?", "var", "variable", "v", "declare", "var", "The var keyword can be used to declare a variable in JavaScript."},
            {"Which symbol is used for single-line comments in JavaScript?", "//", "/*", "#", "<!--", "//", "Two forward slashes are used to create a single-line comment in JavaScript."},
            {"Which method is used to display a message in the console?", "print()", "console.log()", "display()", "show()", "console.log()", "The console.log() method prints information to the browser or development console."},
            {"Which of these is a JavaScript data type?", "String", "HTML", "CSS", "XML", "String", "String is a built-in JavaScript data type used to represent text."},
            {"Which keyword defines a constant variable?", "let", "var", "const", "constant", "const", "The const keyword declares a variable whose binding cannot be reassigned."},
            {"Which operator is used for strict equality?", "=", "==", "===", "!=", "===", "The === operator compares both value and data type without performing type conversion."},
            {"Which method is used to add an item to the end of an array?", "push()", "add()", "append()", "insert()", "push()", "The push() method adds one or more elements to the end of an array."},
            {"Which keyword is used to define a function?", "function", "def", "method", "fun", "function", "The function keyword is used to declare a function in JavaScript."},
            {"Which object is used to work with dates in JavaScript?", "Time", "Date", "Calendar", "Clock", "Date", "The Date object is used to create and work with dates and times in JavaScript."},
            {"Which statement is used to make a decision in JavaScript?", "for", "if", "loop", "switcher", "if", "The if statement executes code when a specified condition is true."}
    };

    String[][] sqlQuestions = {
            {"What does SQL stand for?", "Structured Query Language", "Simple Query Language", "System Query Language", "Standard Question Language", "Structured Query Language", "SQL stands for Structured Query Language and is used to work with relational databases."},
            {"Which command is used to retrieve data from a database?", "GET", "SELECT", "FETCH", "SHOW", "SELECT", "The SELECT statement is used to retrieve data from one or more database tables."},
            {"Which command is used to add new data to a table?", "ADD", "INSERT", "CREATE", "UPDATE", "INSERT", "The INSERT statement is used to add new records to a database table."},
            {"Which key uniquely identifies a record in a table?", "Foreign Key", "Primary Key", "Candidate Key", "Super Key", "Primary Key", "A primary key uniquely identifies each record in a table."},
            {"Which command is used to remove a table?", "DELETE", "REMOVE", "DROP", "CLEAR", "DROP", "The DROP command removes a database object such as a table."},
            {"Which command is used to modify existing data?", "CHANGE", "UPDATE", "MODIFY", "ALTER", "UPDATE", "The UPDATE statement is used to modify existing records in a table."},
            {"Which clause is used to filter records?", "ORDER BY", "WHERE", "GROUP BY", "HAVING", "WHERE", "The WHERE clause filters records based on a specified condition."},
            {"Which command is used to create a new table?", "MAKE", "NEW", "CREATE", "BUILD", "CREATE", "The CREATE TABLE statement is used to create a new table in a database."},
            {"Which SQL keyword is used to sort query results?", "SORT BY", "ORDER BY", "ARRANGE", "GROUP BY", "ORDER BY", "The ORDER BY clause sorts query results in ascending or descending order."},
            {"Which key is used to connect two tables?", "Primary Key", "Foreign Key", "Unique Key", "Main Key", "Foreign Key", "A foreign key creates a relationship between records in two related tables."}
    };

    String[][] computerQuestions = {
            {"What is the brain of a computer?", "RAM", "Hard Disk", "CPU", "Monitor", "CPU", "The CPU processes instructions and performs the main computational operations of a computer."},
            {"Which device is used to enter text into a computer?", "Monitor", "Keyboard", "Printer", "Speaker", "Keyboard", "A keyboard is an input device commonly used to enter text and commands."},
            {"What does RAM stand for?", "Random Access Memory", "Read Access Memory", "Rapid Access Machine", "Random Application Memory", "Random Access Memory", "RAM stands for Random Access Memory and temporarily stores data being actively used."},
            {"Which of these is an operating system?", "Google", "Windows", "Intel", "Oracle", "Windows", "Windows is an operating system that manages computer hardware and software resources."},
            {"Which device is commonly used to store data permanently?", "RAM", "CPU", "Hard Disk", "Keyboard", "Hard Disk", "A hard disk is a storage device used to store data persistently."},
            {"What does CPU stand for?", "Central Processing Unit", "Computer Processing Unit", "Central Program Unit", "Control Processing Unit", "Central Processing Unit", "CPU stands for Central Processing Unit, which executes instructions and processes data."},
            {"Which device is used to display output?", "Keyboard", "Mouse", "Monitor", "Scanner", "Monitor", "A monitor is an output device that displays visual information from the computer."},
            {"Which device is commonly used to move the pointer?", "Keyboard", "Mouse", "Printer", "Speaker", "Mouse", "A mouse is a pointing device commonly used to control the pointer on the screen."},
            {"What is the full form of USB?", "Universal Serial Bus", "United System Bus", "Universal System Board", "User Serial Bus", "Universal Serial Bus", "USB stands for Universal Serial Bus and is commonly used to connect devices and transfer data."},
            {"Which of these is a web browser?", "Windows", "Google Chrome", "Linux", "Oracle", "Google Chrome", "Google Chrome is a web browser used to access websites and web applications."}
    };

    String[][] selectedQuestions;

    String[] shuffledOptions;
    String correctAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        categoryTitle = findViewById(R.id.categoryTitle);
        questionNumber = findViewById(R.id.questionNumber);
        questionText = findViewById(R.id.questionText);
        optionsGroup = findViewById(R.id.optionsGroup);
        timerText = findViewById(R.id.timerText);
        explanationText = findViewById(R.id.explanationText);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        nextButton = findViewById(R.id.nextButton);
        quizProgress = findViewById(R.id.quizProgress);

        setupOptionSelection();

        category = getIntent().getStringExtra("category");

        if (category == null) {
            category = "Computer Basics";
        }

        if ("Java".equals(category)) {
            selectedQuestions = questions;
        } else if ("HTML & CSS".equals(category)) {
            selectedQuestions = htmlQuestions;
        } else if ("JavaScript".equals(category)) {
            selectedQuestions = javascriptQuestions;
        } else if ("SQL & DBMS".equals(category)) {
            selectedQuestions = sqlQuestions;
        } else {
            selectedQuestions = computerQuestions;
        }

        quizProgress.setMax(selectedQuestions.length);
        categoryTitle.setText(category + " Quiz");

        showQuestion();

        nextButton.setOnClickListener(v -> checkAnswer());
    }

    private void setupOptionSelection() {

        RadioButton[] options = {
                option1, option2, option3, option4
        };

        for (RadioButton option : options) {

            option.setOnClickListener(v -> {

                if (attempts == 1
                        && wrongOption != null
                        && v.getId() != wrongOption.getId()) {

                    resetOption(wrongOption);
                    wrongOption = null;
                }

            });
        }
    }

    private void showQuestion() {

        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        String[] question = selectedQuestions[currentQuestion];

        questionNumber.setText(
                "Question " + (currentQuestion + 1) +
                        " of " + selectedQuestions.length
        );

        questionText.setText(question[0]);

        shuffledOptions = new String[]{
                question[1],
                question[2],
                question[3],
                question[4]
        };

        correctAnswer = question[5];

        ArrayList<String> optionList = new ArrayList<>();

        Collections.addAll(optionList, shuffledOptions);
        Collections.shuffle(optionList);

        option1.setText(optionList.get(0));
        option2.setText(optionList.get(1));
        option3.setText(optionList.get(2));
        option4.setText(optionList.get(3));

        resetOption(option1);
        resetOption(option2);
        resetOption(option3);
        resetOption(option4);

        optionsGroup.clearCheck();

        option1.setEnabled(true);
        option2.setEnabled(true);
        option3.setEnabled(true);
        option4.setEnabled(true);

        explanationText.setVisibility(TextView.GONE);
        explanationText.setText("");

        attempts = 0;
        wrongOption = null;

        quizProgress.setProgress(currentQuestion + 1);

        if (currentQuestion == selectedQuestions.length - 1) {
            nextButton.setText("Finish Quiz");
        } else {
            nextButton.setText("Next Question");
        }

        startTimer();
    }

    private void resetOption(RadioButton option) {
        option.setBackgroundResource(R.drawable.option_background);
        option.setTextColor(Color.WHITE);
    }

    private void startTimer() {

        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        countDownTimer = new CountDownTimer(15000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

                long seconds = millisUntilFinished / 1000;

                timerText.setText(seconds + "s");

                if (seconds <= 5) {
                    timerText.setTextColor(
                            Color.parseColor("#EF4444")
                    );
                } else {
                    timerText.setTextColor(
                            Color.parseColor("#7C5CFC")
                    );
                }
            }

            @Override
            public void onFinish() {

                timerText.setText("TIME UP");
                timerText.setTextColor(
                        Color.parseColor("#EF4444")
                );

                if (attempts == 0) {

                    attempts = 1;

                    Toast.makeText(
                            QuizActivity.this,
                            "Time up! You have one more attempt.",
                            Toast.LENGTH_SHORT
                    ).show();

                    optionsGroup.clearCheck();

                    resetOption(option1);
                    resetOption(option2);
                    resetOption(option3);
                    resetOption(option4);

                    wrongOption = null;

                    startTimer();

                } else {

                    disableOptions();

                    showCorrectAnswer(correctAnswer);

                    showExplanation();

                    nextButton.postDelayed(
                            () -> moveToNextQuestion(),
                            2000
                    );
                }
            }
        };

        countDownTimer.start();
    }

    private void checkAnswer() {

        int selectedId = optionsGroup.getCheckedRadioButtonId();

        if (selectedId == -1) {
            Toast.makeText(
                    this,
                    "Please select an answer",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }

        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        RadioButton selectedOption = findViewById(selectedId);

        String selectedAnswer = selectedOption.getText().toString();

        attempts++;

        if (selectedAnswer.equals(correctAnswer)) {

            score++;

            selectedOption.setBackgroundResource(
                    R.drawable.correct_answer
            );

            selectedOption.setTextColor(Color.WHITE);

            showExplanation();

            disableOptions();

            nextButton.postDelayed(
                    () -> moveToNextQuestion(),
                    2000
            );

        } else {

            selectedOption.setBackgroundResource(
                    R.drawable.wrong_answer
            );

            selectedOption.setTextColor(Color.WHITE);

            if (attempts == 1) {

                wrongOption = selectedOption;

                Toast.makeText(
                        this,
                        "Wrong answer! Try again.",
                        Toast.LENGTH_SHORT
                ).show();

                option1.setEnabled(true);
                option2.setEnabled(true);
                option3.setEnabled(true);
                option4.setEnabled(true);

                optionsGroup.clearCheck();

                startTimer();

            } else {

                disableOptions();

                showCorrectAnswer(correctAnswer);

                showExplanation();

                nextButton.postDelayed(
                        () -> moveToNextQuestion(),
                        2000
                );
            }
        }
    }

    private void showCorrectAnswer(String correctAnswer) {

        if (option1.getText().toString().equals(correctAnswer)) {

            option1.setBackgroundResource(
                    R.drawable.correct_answer
            );

            option1.setTextColor(Color.WHITE);

        } else if (option2.getText().toString().equals(correctAnswer)) {

            option2.setBackgroundResource(
                    R.drawable.correct_answer
            );

            option2.setTextColor(Color.WHITE);

        } else if (option3.getText().toString().equals(correctAnswer)) {

            option3.setBackgroundResource(
                    R.drawable.correct_answer
            );

            option3.setTextColor(Color.WHITE);

        } else if (option4.getText().toString().equals(correctAnswer)) {

            option4.setBackgroundResource(
                    R.drawable.correct_answer
            );

            option4.setTextColor(Color.WHITE);
        }
    }

    private void showExplanation() {

        String explanation =
                selectedQuestions[currentQuestion][6];

        explanationText.setText(
                "Why is this correct?\n\n" + explanation
        );

        explanationText.setVisibility(TextView.VISIBLE);
    }

    private void disableOptions() {

        option1.setEnabled(false);
        option2.setEnabled(false);
        option3.setEnabled(false);
        option4.setEnabled(false);
    }

    private void moveToNextQuestion() {

        if (currentQuestion < selectedQuestions.length - 1) {

            currentQuestion++;
            showQuestion();

        } else {

            openResult();
        }
    }

    private void openResult() {

        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        Intent intent = new Intent(
                QuizActivity.this,
                ResultActivity.class
        );

        intent.putExtra("category", category);
        intent.putExtra("score", score);
        intent.putExtra("total", selectedQuestions.length);

        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {

        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        super.onDestroy();
    }
}
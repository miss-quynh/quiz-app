package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private QuestionLibrary questionLibrary = new QuestionLibrary();

    private TextView scoreTracker;
    private TextView questionTracker;
    private TextView questionView;
    private RadioButton multipleChoice1;
    private RadioButton multipleChoice2;
    private RadioButton multipleChoice3;
    private RadioButton multipleChoice4;

    private String correctAnswer;
    private int currentScore = 0;
    private int currentQuestion = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTracker = (TextView) findViewById(R.id.current_score);
        questionTracker = (TextView) findViewById(R.id.current_question);
        questionView = (TextView) findViewById(R.id.question_text_view);
        multipleChoice1 = (RadioButton) findViewById(R.id.option_1_radio_button);
        multipleChoice2 = (RadioButton) findViewById(R.id.option_2_radio_button);
        multipleChoice3 = (RadioButton) findViewById(R.id.option_3_radio_button);
        multipleChoice4 = (RadioButton) findViewById(R.id.option_4_radio_button);

        updateQuestion();

        View.OnClickListener clickListener = new View.OnClickListener() {
            public void onClick(View view) {
                if (currentQuestion > questionLibrary.getLength()) {
                    Toast.makeText(MainActivity.this, "PLEASE STOP CLICKING!", Toast.LENGTH_SHORT).show();
                } else  {
                    Button b = (Button) view;
                    String toastMessage = "Wrong";
                    int toastLength = Toast.LENGTH_SHORT;
                    if (b.getText() == correctAnswer) {
                        currentScore += 1;
                        updateScore();

                        toastMessage = "Correct";

                    }
                    
                    currentQuestion ++;

                    if (currentQuestion >= questionLibrary.getLength()) {
                        toastMessage += "\nTest is over";
                        toastLength = Toast.LENGTH_LONG;
                    } else {
                        updateQuestionNumber();
                        updateQuestion();
                    }

                    Toast.makeText(MainActivity.this, toastMessage, toastLength).show();

                }
            }
        };

        multipleChoice1.setOnClickListener(clickListener);
        multipleChoice2.setOnClickListener(clickListener);
        multipleChoice3.setOnClickListener(clickListener);
        multipleChoice4.setOnClickListener(clickListener);
    }

    /**
     * This method displays the new question on the screen.
     */
    private void updateQuestion() {
        questionView.setText(questionLibrary.getQuestion(currentQuestion));
        multipleChoice1.setText(questionLibrary.getOption1(currentQuestion));
        multipleChoice2.setText(questionLibrary.getOption2(currentQuestion));
        multipleChoice3.setText(questionLibrary.getOption3(currentQuestion));
        multipleChoice4.setText(questionLibrary.getOption4(currentQuestion));

        correctAnswer = questionLibrary.getCorrectAnswer(currentQuestion);
    }

    /**
     * This method updates the current score on the screen.
     */
    private void updateScore() {
        scoreTracker.setText("" + currentScore);
    }

    /**
     * This method updates the current question number on the screen.
     */
    private void updateQuestionNumber() {
        questionTracker.setText("" + currentQuestion + " / 10");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("currentScore", currentScore);
        outState.putInt("currentQuestionNumber", currentQuestion);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        currentScore = savedInstanceState.getInt("currentScore");
        currentQuestion = savedInstanceState.getInt("currentQuestionNumber");

        updateScore();
        updateQuestionNumber();
        updateQuestion();
    }

}

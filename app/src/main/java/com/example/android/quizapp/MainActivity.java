package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
    private int currentQuestion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTracker = (TextView)findViewById(R.id.current_score);
        questionTracker = (TextView)findViewById(R.id.current_question);
        questionView = (TextView)findViewById(R.id.question_text_view);
        multipleChoice1 = (RadioButton)findViewById(R.id.option_1_radio_button);
        multipleChoice2 = (RadioButton)findViewById(R.id.option_2_radio_button);
        multipleChoice3 = (RadioButton)findViewById(R.id.option_3_radio_button);
        multipleChoice4 = (RadioButton)findViewById(R.id.option_4_radio_button);

        updateQuestion();

        multipleChoice1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                if (multipleChoice1.getText() == correctAnswer){
                    currentScore += 1;
                    updateScore(currentScore);
                    updateQuestionNumber(currentQuestion);
                    updateQuestion();

                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                    updateQuestionNumber(currentQuestion);
                    updateQuestion();
                }
            }
        });

        multipleChoice2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                if (multipleChoice2.getText() == correctAnswer){
                    currentScore += 1;
                    updateScore(currentScore);
                    updateQuestionNumber(currentQuestion);
                    updateQuestion();

                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                    updateQuestionNumber(currentQuestion);
                    updateQuestion();
                }
            }
        });

        multipleChoice3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                if (multipleChoice3.getText() == correctAnswer){
                    currentScore += 1;
                    updateScore(currentScore);
                    updateQuestionNumber(currentQuestion);
                    updateQuestion();

                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                    updateQuestionNumber(currentQuestion);
                    updateQuestion();
                }
            }
        });

        multipleChoice4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                if (multipleChoice4.getText() == correctAnswer){
                    currentScore += 1;
                    updateScore(currentScore);
                    updateQuestionNumber(currentQuestion);
                    updateQuestion();

                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                    updateQuestionNumber(currentQuestion);
                    updateQuestion();
                }
            }
        });
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
        currentQuestion++;
    }

    /**
     * This method updates the current score on the screen.
     *
     * @param point from answering the question correctly
     */
    private void updateScore(int point) {
        scoreTracker.setText("" + currentScore);

    }

    /**
     * This method updates the current question number on the screen.
     *
     * @param number from answering the question correctly
     */
    private void updateQuestionNumber(int number) {
        questionTracker.setText("" + currentQuestion + "/10");
    }
}

package com.example.android.udacityquiz;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


/**
 * This App displays a Udacity Quiz
 */

public class MainActivity extends AppCompatActivity {

    //These variable track whether or not questions are answered correctly
    boolean questionOneChecked = false;
    boolean questionTwoChecked = false;
    boolean questionThreeCorrect = false;
    boolean questionFourChecked = false;
    boolean questionFiveChecked = false;
    boolean questionSixChecked = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //              <----------------------Radio Button Quiz Questions--------------------->

    /**
     * This receives and grades the answer for question one
     */
    public void questionOne(View view) {
        // Is question one answered?
        questionOneChecked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {

            // True, will add 1 point to score
            case R.id.questionOneTrue:
                if (questionOneChecked)
                    questionOneChecked = true;
                break;

            // False, no point
            case R.id.questionOneFalse:
                if (questionOneChecked)
                    questionOneChecked = false;
                break;
        }
    }


    /**
     * This receives the answer for question three
     */
    public void questionThree(View view) {
        // Is question one answered?
        boolean questionThreeChecked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {

            // True, no point
            case R.id.questionThreeTrue:
                if (questionThreeChecked)
                    questionThreeCorrect = false;
                break;

            // False, will add 1 point to score
            case R.id.questionThreeFalse:
                if (questionThreeChecked)
                    questionThreeCorrect = true;
                break;
        }
    }

    /**
     * This receives the answer for question six
     */
    public void questionSix(View view) {
        // Is question six answered?
        questionSixChecked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {

            // Katherine selected, no point
            case R.id.questionSixKatherine:
                if (questionSixChecked)
                    questionSixChecked = false;
                break;

            // Kunal Selected, no point
            case R.id.questionSixKunal:
                if (questionSixChecked)
                    questionSixChecked = false;
                break;

            //Lyla selected, will add 1 point
            case R.id.questionSixLyla:
                if (questionSixChecked)
                    questionSixChecked = true;
                break;
        }
    }


    //              <----------------------Scoring--------------------->

    /**
     * This calculates and displays the quiz score
     */
    public void submitQuiz(View view) {

        int score = 0;

        //grade question one

        if (questionOneChecked) {
            score++;
        }

        //grade question two

            //Get the answer the user typed
            String inputAnswerQ2 = ((EditText) findViewById(R.id.questionTwo_answer)).getText().toString().toLowerCase();

            //Get the right answer
            String correctAnswerQ2 = getString(R.string.Answer_Q2);

            //Compare answers to see if user is correct
            if (inputAnswerQ2.contains(correctAnswerQ2)) {
                questionTwoChecked = true;
                score++;
            }

        //grade question three
        if (questionThreeCorrect) {
            score++;
        }

        //grade question four
            //Get the answer the user typed
            String inputAnswerQ4 = ((EditText) findViewById(R.id.questionFour_answer)).getText().toString().toLowerCase();

            //Get the right answer
            String correctAnswerQ4 = getString(R.string.Answer_Q4);

            //Compare answers to see if user is correct
            if (inputAnswerQ4.contains(correctAnswerQ4)) {
                questionFourChecked = true;
                score++;
            }

        //grade question five
            //Is the katherine box checked?
            CheckBox katherine = (findViewById(R.id.q5_Katherine));

            //Is the Kunal box checked?
            CheckBox kunal = (findViewById(R.id.q5_Kunal));

            //Is the Lyla box checked?
            CheckBox Lyla = (findViewById(R.id.q5_Lyla));

            //Is the Alice box checked?
            CheckBox alice = (findViewById(R.id.q5_Alice));

            if (katherine.isChecked() == true && kunal.isChecked() == true && Lyla.isChecked() == true && alice.isChecked() == false) {
                questionFiveChecked = true;
                score++;
            }

        //grade question six
        if (questionSixChecked) {
            score++;
        }

        //What is the percentage of correct answers?
        int finalScore = (score * 100 / 6);

        String showFinalScore = "You Scored " + finalScore + "%";

        //Display Score as a percentage
        Toast displayFinalScore = Toast.makeText(getApplicationContext(), showFinalScore, Toast.LENGTH_LONG);

        displayFinalScore.show();
    }
}

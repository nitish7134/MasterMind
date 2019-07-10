package com.BuG.mastermind;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private Button button;
    Random random = new Random();
    private EditText guess;
    private TextView res;
    private TextView ResultText = findViewById(R.id.ResultText);
    private int randomNumber;
    private String checkNo,correctNo;
    private int score;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setText("Submit");
        initiate();
    }
    private void initiate(){
        score = 1;
        randomNumber = random.nextInt(10000) + 10000;
        correctNo = Integer.toString(randomNumber);
        guess = findViewById(R.id.try1);
        res = findViewById(R.id.res1);
    }
    private void GameLost(){
            button.setText("START Again");
            ResultText.setText("Result: Sorry! Unlucky Day");
            initiate();
    }
    private void GameWon(){
            button.setText("START Again");
            score=10-score+1;
            ResultText.setText("Result: Bulls Eye! | Score: " + score);
            initiate();
    }
    private char[] resultTrial = {' ' , ' ' , ' ' , ' '};
    private void UpdateRes(boolean RESET){
            if(!RESET){
                checkNo = guess.getText().toString();
                if(checkNo == correctNo)
                    res.setText("X X X X");
                else{
                    for(int i=0;i<4;i++)
                        for(int j=0;i<4;i++) {
                            if(checkNo.charAt(i) == correctNo.charAt(j)) {
                                if (i == j)
                                    resultTrial[i] = 'X';
                                else
                                    resultTrial[j] = '0';
                                correctNo = correctNo.substring(0, j) + 'H' + correctNo.substring(j + 1);
                            }
                        }
                    res.setText(resultTrial[0]+ " " + resultTrial[1] + " " + resultTrial[2] + " " + resultTrial[3]);
                }
            }
    }
    private void updateGuess(){
            if(guess.getId() == R.id.try1){
                guess = findViewById(R.id.try2);
                res = findViewById(R.id.res2);
            }
            else if(guess.getId() == R.id.try2){
                guess = findViewById(R.id.try3);
                res = findViewById(R.id.res3);
            }
            else if(guess.getId() == R.id.try3){
                guess = findViewById(R.id.try4);
                res = findViewById(R.id.res4);
            }
            else if(guess.getId() == R.id.try4){
                guess = findViewById(R.id.try5);
                res = findViewById(R.id.res5);
            }
            else if(guess.getId() == R.id.try5){
                guess = findViewById(R.id.try6);
                res = findViewById(R.id.res6);
            }
            else if(guess.getId() == R.id.try6){
                guess = findViewById(R.id.try7);
                res = findViewById(R.id.res7);
            }
            else if(guess.getId() == R.id.try7){
                guess = findViewById(R.id.try8);
                res = findViewById(R.id.res8);
            }
            else if(guess.getId() == R.id.try8){
                guess = findViewById(R.id.try9);
                res = findViewById(R.id.res9);
            }
            else if(guess.getId() == R.id.try9){
                guess = findViewById(R.id.try10);
                res = findViewById(R.id.res10);
            }
    }
    public void Game(View v){
            guess.setEnabled(false);
            UpdateRes(false);
            if(res.getText().toString() == "X X X X")
                GameWon();
            score++;
            if(score>10) {
                GameLost();
            }
            updateGuess();
            guess.setEnabled(true);
    }
}

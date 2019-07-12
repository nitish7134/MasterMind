package com.BuG.mastermind;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private Button button;
    Random random = new Random();
    private EditText guess;
    private TextView res;
    private TextView ResultText;
    private int randomNumber;
    private String checkNo,correctNo;
    private int score;
    private TextView Debug;
    private Button StartButton,NewButton;
    private void initiate(){
        button.setText("Submit");
        ResultText.setText("Result: ");
        score = 1;
        randomNumber = random.nextInt(1000)+1000;
        correctNo = Integer.toString(randomNumber);
        guess = findViewById(R.id.try1);
        res = findViewById(R.id.res1);
        Debug = findViewById(R.id.DEBUG);
        Debug.setText(correctNo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        ResultText = findViewById(R.id.ResultText);
        StartButton = findViewById(R.id.StartButton);
        guess = findViewById(R.id.try1);
        guess.setHint("Enter Here");
        NewButton = findViewById(R.id.StartAgain);
        initiate();
    }

    private void GameLost(){
            ResultText.setText("Result: Sorry! Unlucky Day");
            button.setVisibility(View.INVISIBLE);
            NewButton.setVisibility(View.VISIBLE);
    }
    private void GameWon(){
            ResultText.setText("Result: Bulls Eye! | Score: " + (101-score));
            button.setVisibility(View.INVISIBLE);
            NewButton.setVisibility(View.VISIBLE);
    }
    String temp;

    public void UpdateRes(){
         char[] resultTrial = {' ' , ' ' , ' ' , ' '};
        checkNo = res.getText().toString();
        if(checkNo.compareTo(correctNo) == 0){
            GameWon();
            return;
        }
        String ResultT ="";
        temp = correctNo;
        checkNo = guess.getText().toString();
        //boolean flagWTF = false;
        int s = checkNo.length();
        Log.d("WTF LENGTH","" + s);
        if(s!=4){
            Log.d("Which wtf","NOT 4");
            res.setText("WTF YOU Entering");
            return;
        }
            boolean flag =true;
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        Log.d("internal", "Hi" + i + ':' + j);
                        if (checkNo.charAt(i) == correctNo.charAt(j)) {
                            correctNo = correctNo.substring(0, j) + '|' + correctNo.substring(j + 1);  //'|' is anything arbitrary;
                            flag = false;
                            if (i == j)
                                resultTrial[i] = 'X';
                            else
                                resultTrial[i] = '0';
                            Log.d("internal", "found at" + i + ':' + j);
                            break;
                        }
                    }
                }
                if (flag)
                    ResultT = "Sed Lyf!";
                else
                    ResultT = resultTrial[0] + " " + resultTrial[1] + ' ' + resultTrial[2] + ' ' + resultTrial[3];

                Log.d("HI",ResultT + "  : " + resultTrial[0] + " " + resultTrial[1]);
                Log.d("WTF",correctNo + "  " + randomNumber + " " + checkNo);
                res.setText("Result: " + ResultT);
        correctNo = temp;
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
            }else if(guess.getId() == R.id.try10){
                guess = findViewById(R.id.try1);
                res = findViewById(R.id.res1);
            }
        guess.setVisibility(View.VISIBLE);
        guess.setHint("Enter Here");
        guess.setText("");

    }
    public void OnStarClick(View V){
        button.setVisibility(View.VISIBLE);
        StartButton.setVisibility(View.INVISIBLE);
    }
    private void ResetEverything(){


    }
    public void StartNew(View V){
        ResetEverything();
        initiate();
        button.setVisibility(View.VISIBLE);
        NewButton.setVisibility(View.INVISIBLE);
    }
    public void Game(View v){
                                         Debug.setText(correctNo);
            guess.setEnabled(false);
            UpdateRes();
            score++;
            if(score>100) {
                GameLost();
            }
            updateGuess();
            guess.setEnabled(true);
    }
}

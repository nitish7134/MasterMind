package com.BuG.mastermind;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    public boolean Status; //for Future visions.
    Random random = new Random();
    private EditText guess;
    private TextView res;
    private TextView ResultText = findViewById(R.id.ResultText);
    private int randomNumber;
    private int checkNo;
    private int score;
    private Button button;
    private boolean pressed = false;

    public void initiate(){
        score = 0;
        randomNumber = random.nextInt(1000)+1000;
        ResultText.setText("");
    }
    public void getInput(){
        while(!pressed){}
        checkNo = Integer.parseInt(guess.getText().toString());
        pressed = false;
        if(checkNo<1000 || checkNo>9999)
            getInput();
    }
    private void getRes(){
        String result = "";
        String temp = Integer.toString(checkNo);
        String anstemp = Integer.toString(randomNumber);
        for(int i=0;i<temp.length();i++){
            for(int j=0;j<anstemp.length();j++){
                if(temp.charAt(i)==anstemp.charAt(j)){
                  //  temp.remove(i);
                 //   anstemp.remove(j);
                    if(i==j) {
                        result += "X";
                    }else
                        result += "0";
                }

            }
        }
        res.setText(result);
    }
    private void getGuessAndRes(){
        if(score==1)
            guess = findViewById(R.id.try1);
            res = findViewById(R.id.res1);
    }
    public void Game( View view) {
        getGuessAndRes();
        guess.setEnabled(true);
        getInput();
        guess.setEnabled(false);

        if (checkNo == randomNumber) {
            ResultText.setText(("Bulls Eye! You Got it.\n Score : " + score));
            initiate();
            Game(view);
        }
        getRes();
        score++;
        if (score > 10) {
            ResultText.setText("Result : Unlucky Day Boi!");
            Game(view);
        }
    }


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        initiate();
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    pressed = true;
                }
            });
    }

}

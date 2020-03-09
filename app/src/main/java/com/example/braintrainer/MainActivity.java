package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int seconds = 30 ,sum,correctAnswers=0,totalQuestion=0;
    private TextView timer;
    private TextView score ;
    private TextView answerPop;
    private TextView question;
    private Button buttonArray [];
    private Button playAgain;
    private Button A ;
    private Button B ;
    private Button C ;
    private Button D ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = findViewById(R.id.timer);
        score = findViewById(R.id.score);
        answerPop = findViewById(R.id.answerText);
        playAgain = findViewById(R.id.playAgain);
        playAgain.setVisibility(View.GONE);
        setTextToButtons();
        new CountDownTimer(30000,1000){

            public void onTick(long m){
                timer.setText("Timer\n"+Integer.toString(seconds));
                score.setText("Score\n"+correctAnswers+"/"+totalQuestion);
                seconds--;

            }
            public void onFinish(){
                timer.setText("Timer\n"+Integer.toString(seconds));
                for(int i = 0 ; i < 4 ; i++){
                    buttonArray[i].setEnabled(false);
                    buttonArray[i].setVisibility(View.GONE);
                }
                score.setText("Score");
                answerPop=findViewById(R.id.answerText);
                answerPop.setText("You got " + correctAnswers + "/"+totalQuestion +" correct!");
                playAgain.setVisibility(View.VISIBLE);
            }
        }.start();

    }
    //when called sets the UI.
    public void setTextToButtons(){
        int x = (int)(Math.random()*101);
        int y = (int)(Math.random()*101);
        int answerPosition;
        A = findViewById(R.id.optionA);
        B = findViewById(R.id.optionB);
        C = findViewById(R.id.optionC);
        D = findViewById(R.id.optionD);
        buttonArray = new Button[4];
        buttonArray[0] = A;
        buttonArray[1] = B;
        buttonArray[2] = C;
        buttonArray[3] = D;
        sum = x+y;
        answerPosition = (int)(Math.random()*4);
        for(int i = 0 ; i < 4 ; i++){
            if(i == answerPosition){
                buttonArray[i].setText(Integer.toString(sum));
            }else{
                buttonArray[i].setText(Integer.toString((int)(Math.random()*101)));
            }
        }
        String text;
        text = x + " + "+ y +" = ?";
        question = findViewById(R.id.question);
        question.setText(text);
    }
    //onClick to check if the button clicked is the correct answer, and updates UI appropriately.
    public void answer(View v){
        totalQuestion++;
        String buttonText;
        if(v.getId()==A.getId() ){
            buttonText = A.getText().toString();
            if(Integer.parseInt(buttonText)==sum){//correct answer.
                correctAnswers++;
                score=findViewById(R.id.score);
                score.setText("Score\n"+correctAnswers+"/"+totalQuestion);
                answerPop.setText("Correct answer!");
                answerPop.setVisibility(View.VISIBLE);
                setTextToButtons();
            }else{
                answerPop.setVisibility(View.VISIBLE);
                score=findViewById(R.id.score);
                score.setText("Score\n"+correctAnswers+"/"+totalQuestion);
                answerPop.setText("Wrong answer!");
                answerPop.setVisibility(View.VISIBLE);
                setTextToButtons();
            }
        }
        if(v.getId()==B.getId() ){
            buttonText = B.getText().toString();
            if(Integer.parseInt(buttonText)==sum){//correct answer.
                correctAnswers++;
                score=findViewById(R.id.score);
                score.setText("Score\n"+correctAnswers+"/"+totalQuestion);
                answerPop.setText("Correct answer!");
                answerPop.setVisibility(View.VISIBLE);
                setTextToButtons();
            }else{
                score=findViewById(R.id.score);
                score.setText("Score\n"+correctAnswers+"/"+totalQuestion);
                answerPop.setText("Wrong answer!");
                answerPop.setVisibility(View.VISIBLE);
                setTextToButtons();
            }
        }
        if(v.getId()==C.getId() ){
            buttonText = C.getText().toString();
            if(Integer.parseInt(buttonText)==sum){//correct answer.
                correctAnswers++;
                score=findViewById(R.id.score);
                score.setText("Score\n"+correctAnswers+"/"+totalQuestion);
                answerPop.setText("Correct answer!");
                answerPop.setVisibility(View.VISIBLE);
                setTextToButtons();
            }else{
                score=findViewById(R.id.score);
                score.setText("Score\n"+correctAnswers+"/"+totalQuestion);
                answerPop.setText("Wrong answer!");
                answerPop.setVisibility(View.VISIBLE);
                setTextToButtons();
            }
        }
        if(v.getId()==D.getId() ){
            buttonText = D.getText().toString();
            if(Integer.parseInt(buttonText)==sum){//correct answer.
                correctAnswers++;
                score=findViewById(R.id.score);
                score.setText("Score\n"+correctAnswers+"/"+totalQuestion);
                answerPop.setText("Correct answer!");
                answerPop.setVisibility(View.VISIBLE);
                setTextToButtons();
            }else{
                score=findViewById(R.id.score);
                score.setText("Score\n"+correctAnswers+"/"+totalQuestion);
                answerPop.setText("Wrong answer!");
                answerPop.setVisibility(View.VISIBLE);
                setTextToButtons();
            }
        }

    }
    //when clicked we start a new game.
    public void playAgain(View v){
        seconds=30;
        answerPop.setVisibility(View.GONE);
        for(int i = 0 ; i < 4 ; i++){
            buttonArray[i].setVisibility(View.VISIBLE);
            buttonArray[i].setEnabled(true);
        }
        totalQuestion = 0;
        correctAnswers = 0;
        new CountDownTimer(30000,1000){

            public void onTick(long m){
                timer.setText("Timer\n"+Integer.toString(seconds));
                seconds--;

            }
            public void onFinish(){
                timer.setText("Timer\n"+Integer.toString(seconds));
                for(int i = 0 ; i < 4 ; i++){
                    buttonArray[i].setEnabled(false);
                    buttonArray[i].setVisibility(View.GONE);
                }
                score.setText("Score");
                answerPop=findViewById(R.id.answerText);
                answerPop.setText("You got " + correctAnswers + "/"+totalQuestion +" correct!");
                playAgain.setVisibility(View.VISIBLE);
            }
        }.start();
    }
}

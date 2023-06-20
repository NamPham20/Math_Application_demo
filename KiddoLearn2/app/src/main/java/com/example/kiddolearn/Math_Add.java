package com.example.kiddolearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;



public class Math_Add extends AppCompatActivity implements View.OnClickListener{

    private TextView tvQuestion;
    private Button btnAnswer1;
    private Button btnAnswer2;
    private Button btnAnswer3;
    private Button btnAnswer4;
    private TextView tvAlarms;
    private QuestionMath questionMath;
    private TextView tvScores;

    private TextView tvBackToMath_menu;
    private  TextView tvLevel;

    private ImageView  imvHeart1;
    private ImageView  imvHeart2;
    private ImageView  imvHeart3;
    private CountDownTimer countDownTimer;
    int Scores = 0;
    int value ;
    int heart = 3;

    String typeQuestion;

    int countQuestion=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_add);
        Intent intent = getIntent();
        value = intent.getIntExtra("key",0);
        typeQuestion = intent.getStringExtra("TypeQuestion");
        initUi();


        if(value == 10){
            tvLevel.setText("  LEVEL   -   1");
        } else if (value == 100) {
            tvLevel.setText("  LEVEL   -   2");
        }
        else if (value == 500) {
            tvLevel.setText("  LEVEL   -   3");
        }else if (value == 1000) {
            tvLevel.setText("  LEVEL   -   4");
        }
        setTypeQuestion();

        tvBackToMath_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Math_Add.this,Math_Menu.class);
                startActivity(intent);
            }
        });


    }

    private void setTypeQuestion() {
        if(typeQuestion.equals("Phép Cộng")){
            setTvQuestion(getAddQuestionmath(value));
        } else if (typeQuestion.equals("Phép Trừ")) {
            setTvQuestion(getSubQuestionmath(value));
        }

    }

    public void setTvQuestion(QuestionMath qMath){
        setCountdowTime(tvAlarms);
        questionMath= qMath;

        tvQuestion.setText(qMath.getQuestion());
        tvScores.setText(""+ Scores);
        btnAnswer1.setTextColor(Color.WHITE);
        btnAnswer2.setTextColor(Color.WHITE);
        btnAnswer3.setTextColor(Color.WHITE);
        btnAnswer4.setTextColor(Color.WHITE);



        btnAnswer1.setText(qMath.getmListAnswers().get(0).getConten());
        btnAnswer2.setText(qMath.getmListAnswers().get(1).getConten());
        btnAnswer3.setText(qMath.getmListAnswers().get(2).getConten());
        btnAnswer4.setText(qMath.getmListAnswers().get(3).getConten());

        btnAnswer1.setOnClickListener(this);
        btnAnswer2.setOnClickListener(this);
        btnAnswer3.setOnClickListener(this);
        btnAnswer4.setOnClickListener(this);

    }

    public QuestionMath getAddQuestionmath(int value){
        if(value<=0){
            Toast.makeText(this,"ERROR",Toast.LENGTH_SHORT).show();
            value = 50;
        }
            Random random = new Random();
            int[] numbers = new int[2];
            numbers[0] = random.nextInt(value -0)+1;
            numbers[1] = random.nextInt(value-0)+1;

            String question = numbers[0] + " + " + numbers[1] + " = ?";
            // get answers
            int[] result = new int[4];
            int sum = numbers[0] + numbers[1];
            result[0] = sum;
            if (numbers[0] < numbers[1]) {
                result[1] = random.nextInt(numbers[0]);
                result[2] = random.nextInt(numbers[1] - numbers[0] + 1) + numbers[0];
            } else {
                result[1] = random.nextInt(numbers[1]);
                result[2] = random.nextInt(numbers[0] - numbers[1] + 1) + numbers[1];
            }
            result[3] = random.nextInt((sum + value) - sum + 2) + sum + 1;


            List<QuestionMath.Answers> mListAnswers = new ArrayList<>();

            QuestionMath.Answers answer1 = new QuestionMath.Answers(String.valueOf(result[0]), true);
            QuestionMath.Answers answer2 = new QuestionMath.Answers(String.valueOf(result[1]), false);
            QuestionMath.Answers answer3 = new QuestionMath.Answers(String.valueOf(result[2]), false);
            QuestionMath.Answers answer4 = new QuestionMath.Answers(String.valueOf(result[3]), false);

            mListAnswers.add(answer1);
            mListAnswers.add(answer2);
            mListAnswers.add(answer3);
            mListAnswers.add(answer4);

            Collections.shuffle(mListAnswers);
            questionMath = new QuestionMath(question, mListAnswers);
            return questionMath;

    }

    public QuestionMath getSubQuestionmath(int value){
        if(value<=0){
            Toast.makeText(this,"ERROR",Toast.LENGTH_SHORT).show();
            value = 50;
        }
        Random random = new Random();
        int[] numbers = new int[2];
        numbers[0] = random.nextInt(value -0)+1;
        numbers[1] = random.nextInt(value-0)+1;
        String question;
        if(numbers[0]>=numbers[1]){
           question  = numbers[0] + " - " + numbers[1] + " = ?";
        }else {
           question = numbers[1] + " - " + numbers[0] + " = ?";
        }

        // get answers
        int[] result = new int[4];
        int sub = Math.abs(numbers[0] - numbers[1]) ;
        result[0] = sub;
        if (numbers[0] < numbers[1]) {
            result[1] = random.nextInt(numbers[1] - sub+2)+(sub+1);
            result[2] = random.nextInt(numbers[1]+100 - numbers[1] + 1) + numbers[1];
        } else {
            result[1] = random.nextInt(numbers[0] - sub+2)+sub+1;
            result[2] = random.nextInt(numbers[0]+100 - numbers[0] + 1) + numbers[0];
        }
        result[3] = random.nextInt((sub + value) - sub + 2) + sub + 1;
        
        for(int i=1;i<4;i++){
            if (result[i]==result[0]){
                result[i]+=1;
            }
        }


        List<QuestionMath.Answers> mListAnswers = new ArrayList<>();

        QuestionMath.Answers answer1 = new QuestionMath.Answers(String.valueOf(result[0]), true);
        QuestionMath.Answers answer2 = new QuestionMath.Answers(String.valueOf(result[1]), false);
        QuestionMath.Answers answer3 = new QuestionMath.Answers(String.valueOf(result[2]), false);
        QuestionMath.Answers answer4 = new QuestionMath.Answers(String.valueOf(result[3]), false);

        mListAnswers.add(answer1);
        mListAnswers.add(answer2);
        mListAnswers.add(answer3);
        mListAnswers.add(answer4);

        Collections.shuffle(mListAnswers);
        questionMath = new QuestionMath(question, mListAnswers);
        return questionMath;

    }

    public void initUi(){

        tvQuestion = findViewById(R.id.tvQuestion);
        tvAlarms   = findViewById(R.id.tvAlamrs);
        btnAnswer1 = findViewById(R.id.btnAnswer1);
        btnAnswer2 = findViewById(R.id.btnAnswer2);
        btnAnswer3 = findViewById(R.id.btnAnswer3);
        btnAnswer4 = findViewById(R.id.btnAnswer4);
        tvScores=findViewById(R.id.tvScores);
        tvBackToMath_menu= findViewById(R.id.tvBackToMath_menu);
        tvLevel = findViewById(R.id.tvLevel);
        imvHeart1 =findViewById(R.id.imvHeart1);
        imvHeart2 =findViewById(R.id.imvHeart2);
        imvHeart3 =findViewById(R.id.imvHeart3);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnAnswer1) {
            checkAnswer(btnAnswer1,questionMath,questionMath.getmListAnswers().get(0),view.getContext());
        } else if (id == R.id.btnAnswer2) {
            checkAnswer(btnAnswer2,questionMath,questionMath.getmListAnswers().get(1),view.getContext());
        } else if (id == R.id.btnAnswer3) {
            checkAnswer(btnAnswer3,questionMath,questionMath.getmListAnswers().get(2),view.getContext());
        }
        else if (id == R.id.btnAnswer4) {
            checkAnswer(btnAnswer4,questionMath,questionMath.getmListAnswers().get(3),view.getContext());
        }

    }

    public void checkAnswer(Button btnAnswer,QuestionMath qMath, QuestionMath.Answers answers, Context context){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (answers.istrue){
                    btnAnswer.setTextColor(Color.GREEN);
                    Toast.makeText(context,"Success!",Toast.LENGTH_SHORT).show();
                    countQuestion++;
                    setScores();
                    nextQuestion();
                }else{
                    btnAnswer.setTextColor(Color.RED);
                    Toast.makeText(context,"False!",Toast.LENGTH_SHORT).show();
                    Scores-=50;
                    tvScores.setText(""+ Scores);
                    gameOver();

                }
            }
        },1000);
    }

    private void gameOver() {
        heart --;
        if(heart == 2){
            imvHeart3.setImageResource(R.drawable.baseline_favorite_border);
        }else if (heart == 1){
            imvHeart2.setImageResource(R.drawable.baseline_favorite_border);
        }else {
            Intent intent= new Intent(Math_Add.this,GameOver.class);
            int numberQuesstion = countQuestion;
            String Scores = tvScores.getText().toString().trim();
            intent.putExtra("numberQuestion",numberQuesstion);
            intent.putExtra("Scores",Scores);
            startActivity(intent);
            finish();
        }
    }

    private void nextQuestion() {

        QuestionMath questionMath = null;
        if(typeQuestion.equals("Phép Cộng")){
            questionMath = getAddQuestionmath(value);
        }else if(typeQuestion.equals("Phép Trừ")) {
            questionMath = getSubQuestionmath(value);
        }
        countDownTimer.cancel();
        setTvQuestion(questionMath);
    }

    public void setCountdowTime(TextView tvTime){
        long countdownTime = 60000;

        countDownTimer = new CountDownTimer(countdownTime, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long secondsRemaining = millisUntilFinished / 1000;
                tvTime.setText(String.valueOf(secondsRemaining));
            }

            @Override
            public void onFinish() {
                tvTime.setText("TIME UP!");
            }
        };

        countDownTimer.start();
    }

    public void setScores(){
        String time = tvAlarms.getText().toString().trim();
       if(!time.equals("TIME UP!")){
        if(Integer.parseInt(time) >=40 ){
            Scores+=200;
        } else if (Integer.parseInt(time) <=40 && Integer.parseInt(time)>=20) {
            Scores+=100;
        } else if (Integer.parseInt(time)<20) {
            Scores +=50;
        }
    } else {
           Scores +=10;
       }
    }


}
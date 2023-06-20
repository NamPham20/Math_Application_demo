package com.example.kiddolearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {

    private TextView tvCorrectAnswers;
    private TextView tvScoresOver;
    private Button btnHome;

    int number;
    String Scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        initUi();
        Intent intent = getIntent();
        number = intent.getIntExtra("numberQuestion",0);
        Scores = intent.getStringExtra("Scores");
        if(number != 0 && Scores!=null) {
            tvCorrectAnswers.setText("" + number);
            tvScoresOver.setText(Scores);
        }
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(GameOver.this,MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });


    }

    private void initUi() {
        tvCorrectAnswers = findViewById(R.id.tvCorrectAnswers);
        tvScoresOver = findViewById(R.id.tvScoresOver);
        btnHome = findViewById(R.id.btnHome);
    }
}
package com.example.kiddolearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MENU extends AppCompatActivity implements View.OnClickListener {

    private TextView tvStudy;
    private TextView tvPractice;

    private TextView tvMathOperations;

    private String strNameMath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initUi();

        Intent intentGetData = getIntent();
        strNameMath = intentGetData.getStringExtra("Math").trim();
        if(strNameMath.equals(null)){
            return;
        }
        if (strNameMath.equals("Phép Cộng")){
            tvMathOperations.setText(strNameMath);
        } else if (strNameMath.equals("Phép Nhân")) {
            tvMathOperations.setText(strNameMath);
        }else if (strNameMath.equals("Phép Trừ")) {
            tvMathOperations.setText(strNameMath);
        }else if (strNameMath.equals("Phép Chia")) {
            tvMathOperations.setText(strNameMath);
        }

        tvPractice.setOnClickListener(this);
        tvStudy.setOnClickListener(this);

    }

    private void initUi() {
        tvStudy = findViewById(R.id.tvStudy);
        tvPractice = findViewById(R.id.tvPractice);
        tvMathOperations = findViewById(R.id.tvMathOperations);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id==R.id.tvStudy){
            Intent intentPutdata1 =new Intent(MENU.this,CalculusTable.class);
            intentPutdata1.putExtra("TypePractice",strNameMath);
            startActivity(intentPutdata1);
        } else if (id == R.id.tvPractice) {
            Intent intentPutdata2 =new Intent(MENU.this,Math_Menu.class);
            intentPutdata2.putExtra("TypePractice",strNameMath);
            startActivity(intentPutdata2);
        }
    }
}
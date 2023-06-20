package com.example.kiddolearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SubDivTable extends AppCompatActivity {

    private TextView tvCalSub1;
    private TextView tvCalSub2;
    private TextView tvCalSub3;
    private TextView tvCalSub4;
    private TextView tvCalSub5;
    private TextView tvCalSub6;
    private TextView tvCalSub7;
    private TextView tvCalSub8;
    private TextView tvCalSub9;
    private TextView tvCalSub10;
    private Button btnNextSub;

    private TextView tvNameSubTable;

    private String strTypeCalculus;
    private int number;

    List<TextView> mListTv = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_div_table);
        initUi();

        Intent intentGetTypeCal = getIntent();
        strTypeCalculus = intentGetTypeCal.getStringExtra("TypeCalculus");
        number = intentGetTypeCal.getIntExtra("KeyNumber",0);

        if(strTypeCalculus.equals(null) && number==0){
            return;
        }
        tvNameSubTable.setText(strTypeCalculus +" "+ number);

        mListTv.add(tvCalSub1);
        mListTv.add(tvCalSub2);
        mListTv.add(tvCalSub3);
        mListTv.add(tvCalSub4);
        mListTv.add(tvCalSub5);
        mListTv.add(tvCalSub6);
        mListTv.add(tvCalSub7);
        mListTv.add(tvCalSub8);
        mListTv.add(tvCalSub9);
        mListTv.add(tvCalSub10);



        if(strTypeCalculus.equals("Phép Trừ")){
            setSubTable(number);
        } else if (strTypeCalculus.equals("Phép Chia")) {
            setDivTable(number);
        }

    }

    private void setDivTable(int number) {
        int i=number;
        int j=0;
        while (i<=10){
            mListTv.get(j).setText(i*number + " / " + number +" = "+i);
            i++;
            j++;
        }
    }

    private void setSubTable(int number) {
           int i=number;
           int j=0;
           while (i<=10){
               mListTv.get(j).setText(i + " - " + number +" = "+(i-number));
               i++;
               j++;
           }
    }

    private void initUi() {

        tvCalSub1 = findViewById(R.id.tvCalSub1);
        tvCalSub2 = findViewById(R.id.tvCalSub2);
        tvCalSub3 = findViewById(R.id.tvCalSub3);
        tvCalSub4 = findViewById(R.id.tvCalSub4);
        tvCalSub5 = findViewById(R.id.tvCalSub5);
        tvCalSub6 = findViewById(R.id.tvCalSub6);
        tvCalSub7 = findViewById(R.id.tvCalSub7);
        tvCalSub8 = findViewById(R.id.tvCalSub8);
        tvCalSub9 = findViewById(R.id.tvCalSub9);
        tvCalSub10 = findViewById(R.id.tvCalSub10);
        btnNextSub = findViewById(R.id.btnNextSub);
        tvNameSubTable = findViewById(R.id.tvNameSubTable);
    }
}
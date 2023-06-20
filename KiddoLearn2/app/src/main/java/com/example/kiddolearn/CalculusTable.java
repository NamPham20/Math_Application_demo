package com.example.kiddolearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CalculusTable extends AppCompatActivity implements View.OnClickListener {

    private TextView tvNum1;
    private TextView tvNum2;
    private TextView tvNum3;
    private TextView tvNum4;
    private TextView tvNum5;
    private TextView tvNum6;
    private TextView tvNum7;
    private TextView tvNum8;
    private TextView tvNum9;
    private TextView tvNum10;
    private TextView tvNameTable;

    String nameCalculus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculus_table);
        initUi();

        Intent intentGetData = getIntent();
        nameCalculus = intentGetData.getStringExtra("TypePractice");
        tvNameTable.setText(nameCalculus);

        tvNum1.setOnClickListener(this);
        tvNum2.setOnClickListener(this);
        tvNum3.setOnClickListener(this);
        tvNum4.setOnClickListener(this);
        tvNum5.setOnClickListener(this);
        tvNum6.setOnClickListener(this);
        tvNum7.setOnClickListener(this);
        tvNum8.setOnClickListener(this);
        tvNum9.setOnClickListener(this);
        tvNum10.setOnClickListener(this);


    }

    private void initUi() {
        tvNum1 = findViewById(R.id.tvNum1);
        tvNum2 = findViewById(R.id.tvNum2);
        tvNum3 = findViewById(R.id.tvNum3);
        tvNum4 = findViewById(R.id.tvNum4);
        tvNum5 = findViewById(R.id.tvNum5);
        tvNum6 = findViewById(R.id.tvNum6);
        tvNum7 = findViewById(R.id.tvNum7);
        tvNum8 = findViewById(R.id.tvNum8);
        tvNum9 = findViewById(R.id.tvNum9);
        tvNum10 = findViewById(R.id.tvNum10);
        tvNameTable  = findViewById(R.id.tvNameTable);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.tvNum1){
            nextToCalculusTable(tvNum1);

        } else if (id == R.id.tvNum2) {
            nextToCalculusTable(tvNum2);

        }else if (id == R.id.tvNum3) {
            nextToCalculusTable(tvNum3);

        }else if (id == R.id.tvNum4) {
            nextToCalculusTable(tvNum4);

        }else if (id == R.id.tvNum5) {
            nextToCalculusTable(tvNum5);

        }else if (id == R.id.tvNum6) {
            nextToCalculusTable(tvNum6);

        }else if (id == R.id.tvNum7) {
            nextToCalculusTable(tvNum7);

        }else if (id == R.id.tvNum8) {
            nextToCalculusTable(tvNum8);

        }else if (id == R.id.tvNum9) {
            nextToCalculusTable(tvNum9);

        }else if (id == R.id.tvNum10) {
            nextToCalculusTable(tvNum10);
        }
    }

    public  void  nextToCalculusTable(TextView tvNameCal){
        if (nameCalculus.equals("Phép Cộng") || nameCalculus.equals("Phép Nhân")){
            Intent intentPutData1 = new Intent(CalculusTable.this, AddMulTable.class);
            int num1 = Integer.parseInt(tvNameCal.getText().toString());
            intentPutData1.putExtra("TypeCalculus",nameCalculus);
            intentPutData1.putExtra("KeyNumber",num1);
            startActivity(intentPutData1);
        } else {
            Intent intentPutData2 = new Intent(CalculusTable.this, SubDivTable.class);
            int num2 = Integer.parseInt(tvNameCal.getText().toString());
            intentPutData2.putExtra("TypeCalculus",nameCalculus);
            intentPutData2.putExtra("KeyNumber",num2);
            startActivity(intentPutData2);
        }

    }
}
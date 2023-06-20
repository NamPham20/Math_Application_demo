package com.example.kiddolearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class AddMulTable extends AppCompatActivity {

    private TextView tvCalAdd1;
    private TextView tvCalAdd2;
    private TextView tvCalAdd3;
    private TextView tvCalAdd4;
    private TextView tvCalAdd5;
    private TextView tvCalAdd6;
    private TextView tvCalAdd7;
    private TextView tvCalAdd8;
    private TextView tvCalAdd9;
    private TextView tvCalAdd10;
    private Button btnNextAdd;

    private TextView tvNameTable;

    private String strTypeCalculus;
    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_table);
        initUi();

        Intent intentGetTypeCal = getIntent();
        strTypeCalculus = intentGetTypeCal.getStringExtra("TypeCalculus");
        number = intentGetTypeCal.getIntExtra("KeyNumber",0);

        if(strTypeCalculus.equals(null) && number==0){
            return;
        }
        tvNameTable.setText(strTypeCalculus +" "+ number);


        if(strTypeCalculus.equals("Phép Cộng")){
            setAddTable(number);
        } else if (strTypeCalculus.equals("Phép Nhân")) {
            setMulTable(number);
        }
    }

    private void setAddTable(int number) {

        tvCalAdd1.setText(number + " + 0 = "+(number+0));
        tvCalAdd2.setText(number + " + 1 = "+(number+1));
        tvCalAdd3.setText(number + " + 2 = "+(number+2));
        tvCalAdd4.setText(number + " + 3 = "+(number+3));
        tvCalAdd5.setText(number + " + 4 = "+(number+4));
        tvCalAdd6.setText(number + " + 5 = "+(number+5));
        tvCalAdd7.setText(number + " + 6 = "+(number+6));
        tvCalAdd8.setText(number + " + 7 = "+(number+7));
        tvCalAdd9.setText(number + " + 8 = "+(number+8));
        tvCalAdd10.setText(number + " + 9 = "+(number+9));

    }

    private void setMulTable(int number) {

        tvCalAdd1.setText(number + " x 1 = "+(number*1));
        tvCalAdd2.setText(number + " x 2 = "+(number*2));
        tvCalAdd3.setText(number + " x 3 = "+(number*3));
        tvCalAdd4.setText(number + " x 4 = "+(number*4));
        tvCalAdd5.setText(number + " x 5 = "+(number*5));
        tvCalAdd6.setText(number + " x 6 = "+(number*6));
        tvCalAdd7.setText(number + " x 7 = "+(number*7));
        tvCalAdd8.setText(number + " x 8 = "+(number*8));
        tvCalAdd9.setText(number + " x 9 = "+(number*9));
        tvCalAdd10.setText(number + " x 10 = "+(number*10));

    }

    private void initUi() {
        tvCalAdd1 = findViewById(R.id.tvCalAdd1);
        tvCalAdd2 = findViewById(R.id.tvCalAdd2);
        tvCalAdd3 = findViewById(R.id.tvCalAdd3);
        tvCalAdd4 = findViewById(R.id.tvCalAdd4);
        tvCalAdd5 = findViewById(R.id.tvCalAdd5);
        tvCalAdd6 = findViewById(R.id.tvCalAdd6);
        tvCalAdd7 = findViewById(R.id.tvCalAdd7);
        tvCalAdd8 = findViewById(R.id.tvCalAdd8);
        tvCalAdd9 = findViewById(R.id.tvCalAdd9);
        tvCalAdd10 = findViewById(R.id.tvCalAdd10);
        btnNextAdd = findViewById(R.id.btnNextAdd);
        tvNameTable = findViewById(R.id.tvNameTable);
    }
}
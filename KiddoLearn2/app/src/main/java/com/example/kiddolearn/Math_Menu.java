package com.example.kiddolearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Math_Menu extends AppCompatActivity implements View.OnClickListener {

    private TextView tvLevel1;
    private TextView tvLevel2;
    private TextView tvLevel3;
    private TextView tvLevel4;

    private  TextView tvNameMath;

    private TextView tvBackToMain;

    private String strGetNameFromMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_menu);
        initUi();
        Intent intentGetStrData = getIntent();
        strGetNameFromMenu =intentGetStrData.getStringExtra("TypePractice");
        tvNameMath.setText(strGetNameFromMenu);

        tvLevel1.setOnClickListener(this);
        tvLevel2.setOnClickListener(this);
        tvLevel3.setOnClickListener(this);
        tvLevel4.setOnClickListener(this);

        tvBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Math_Menu.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initUi() {
        tvLevel1 = findViewById(R.id.tvLevel1);
        tvLevel2 = findViewById(R.id.tvLevel2);
        tvLevel3 = findViewById(R.id.tvLevel3);
        tvLevel4 = findViewById(R.id.tvLevel4);
        tvBackToMain = findViewById(R.id.tvBackToMain);
        tvNameMath = findViewById(R.id.tvNameMath);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tvLevel1){
            gotoMath(10);
        }else if (id== R.id.tvLevel2){
            gotoMath(100);
        }else if (id== R.id.tvLevel3){
            gotoMath(500);
        }else if (id== R.id.tvLevel4){
            gotoMath(1000);
        }
    }

    private void gotoMath(int value) {
        if (strGetNameFromMenu.equals("Phép Cộng")){
            Intent intent1 = new Intent(Math_Menu.this, Math_Add.class);
            intent1.putExtra("TypeQuestion","Phép Cộng");
            intent1.putExtra("key",value);
            startActivity(intent1);
        }else if (strGetNameFromMenu.equals("Phép Trừ")) {
            Intent intent2 = new Intent(Math_Menu.this, Math_Add.class);
            intent2.putExtra("TypeQuestion","Phép Trừ");
            intent2.putExtra("key",value);
            startActivity(intent2);
        }


    }
}
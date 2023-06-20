package com.example.kiddolearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMathAdd;
    private Button btnMathMul;
    private Button btnMathSub;
    private Button btnMathDiv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();

        btnMathAdd.setOnClickListener(this);
        btnMathMul.setOnClickListener(this);
        btnMathSub.setOnClickListener(this);
        btnMathDiv.setOnClickListener(this);


    }

    public void initUi(){
        btnMathAdd = findViewById(R.id.btnMath_add);
        btnMathMul = findViewById(R.id.btnMath_Mul);
        btnMathSub = findViewById(R.id.btnMath_sub);
        btnMathDiv = findViewById(R.id.btnMath_div);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnMath_add) {
            Click(btnMathAdd);
        } else if (id == R.id.btnMath_Mul) {
            Click(btnMathMul);
        } else if (id == R.id.btnMath_sub) {
            Click(btnMathSub);
        } else if (id == R.id.btnMath_div) {
            Click(btnMathDiv);
        }
    }

    public void Click (Button btn){
        String nameButton = btn.getText().toString().trim();
        Intent intent = new Intent(MainActivity.this,MENU.class);
        if (nameButton.equals("PHÉP CỘNG")){
              intent.putExtra("Math","Phép Cộng");
              startActivity(intent);
        } else if (nameButton.equals("PHÉP NHÂN")) {
            intent.putExtra("Math","Phép Nhân");
            startActivity(intent);
        }else if (nameButton.equals("PHÉP TRỪ")) {
            intent.putExtra("Math","Phép Trừ");
            startActivity(intent);
        }else if (nameButton.equals("PHÉP CHIA")) {
            intent.putExtra("Math","Phép Chia");
            startActivity(intent);
        }
    }
}
package com.kts.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;

    TextView textResult;
    String num1, num2;

    Integer result;
    Double div;

    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4,
                            R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9};

    int i;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("정수 계산기");

        edit1 = (EditText)findViewById(R.id.Edit1);
        edit2 = (EditText)findViewById(R.id.Edit2);

        btnAdd = (Button)findViewById(R.id.BtnAdd);
        btnSub = (Button)findViewById(R.id.BtnSub);
        btnMul = (Button)findViewById(R.id.BtnMul);
        btnDiv = (Button)findViewById(R.id.BtnDiv);

        textResult = (TextView)findViewById(R.id.TextResult);

        btnAdd.setOnClickListener(v -> {            //람다 사용. 나머지 계산 버튼도 마찬가지.
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();
            result = Integer.parseInt(num1) + Integer.parseInt(num2);
            textResult.setText("계산 결과: " + result.toString());
        });

        btnSub.setOnClickListener(v -> {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();
            result = Integer.parseInt(num1) - Integer.parseInt(num2);
            textResult.setText("계산 결과: " + result.toString());
        });

        btnMul.setOnClickListener(v -> {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();
            result = Integer.parseInt(num1) * Integer.parseInt(num2);
            textResult.setText("계산 결과: " + result.toString());
        });

        btnDiv.setOnClickListener(v -> {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();
            div = Double.parseDouble(num1) / Double.parseDouble(num2);
            textResult.setText("계산 결과: " + div.toString() + "\n나눗셈은 실수로 표기됩니다.");
        }); //나눗셈은 애매하기 때문에 정수가 아닌 실수로 표현.

        for(i=0; i<numBtnIDs.length; i++){
            numButtons[i] = (Button)findViewById(numBtnIDs[i]);
        }

        for(i=0; i<numBtnIDs.length; i++){
            final int index;
            index = i;

            numButtons[index].setOnClickListener(v -> { //람다 사용

                if(edit1.isFocused()){
                    num1 = edit1.getText().toString() + numButtons[index].getText().toString();
                    edit1.setText(num1);
                } else if(edit2.isFocused()){
                    num2 = edit2.getText().toString() + numButtons[index].getText().toString();
                    edit2.setText(num2);
                }
                else {
                    Toast.makeText(getApplicationContext(), "먼저 에디트 텍스트를 선택하세요",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
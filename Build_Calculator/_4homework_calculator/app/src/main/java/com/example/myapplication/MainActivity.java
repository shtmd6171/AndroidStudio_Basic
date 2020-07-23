package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView num0;
    TextView num1;
    TextView num2;
    TextView num3;
    TextView num4;
    TextView num5;
    TextView num6;
    TextView num7;
    TextView num8;
    TextView num9;

    TextView plus;
    TextView minus;
    TextView multi;
    TextView divi;
    TextView equal;
    TextView showing;
    TextView clear;

    Integer first = null;
    Integer second = null;
    String operater = null;
    String temp = "";
    String Text = "";
    boolean aBoolean = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FindTextView();
        setOnClick();



    }


    private void FindTextView(){
        num0 = findViewById(R.id.Zero);
        num1 = findViewById(R.id.One);
        num2 = findViewById(R.id.Two);
        num3 = findViewById(R.id.Three);
        num4 = findViewById(R.id.Four);
        num5 = findViewById(R.id.Five);
        num6 = findViewById(R.id.Six);
        num7 = findViewById(R.id.Seven);
        num8 = findViewById(R.id.Eight);
        num9 = findViewById(R.id.Nine);
        plus = findViewById(R.id.Plus);
        minus = findViewById(R.id.Minus);
        multi = findViewById(R.id.Multiply);
        divi = findViewById(R.id.Division);
        equal = findViewById(R.id.Equal);
        showing = findViewById(R.id.Showing);
        clear = findViewById(R.id.Clear);

    }

    private void Operating(int number){
        temp = temp + number ;

        if(operater ==  null){
            first = Integer.parseInt(temp);
        }else if(operater != null){
            second = Integer.parseInt(temp);
        }

    }

    private void LeavingMSG(){
        if(operater == null) {
            showing.setText(String.valueOf(first));
        }else if(aBoolean != true){
            showing.setText(String.valueOf(Text + second));
        }
    }

    private void Clear(){
        temp = "";
        operater = null;
        first = null;
        second = null;
        showing.setText(String.valueOf(0));
    }
    private void setOnClick(){

        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operating(0);
                LeavingMSG();


            }
        });

        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operating(1);
                LeavingMSG();


            }
        });

        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operating(2);
                LeavingMSG();


            }
        });

        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operating(3);
                LeavingMSG();

            }
        });

        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operating(4);
                LeavingMSG();

            }
        });

        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operating(5);
                LeavingMSG();

            }
        });

        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operating(6);
                LeavingMSG();

            }
        });

        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operating(7);
                LeavingMSG();

            }
        });

        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operating(8);
                LeavingMSG();

            }
        });

        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operating(9);
                LeavingMSG();

            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operater == null){
                    operater = "+";
                    temp = "";
                    Text = first + "+";
                    showing.setText(String.valueOf(Text));
                    aBoolean = false ;
                }else{
                    return;
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operater == null){
                    operater = "-";
                    temp = "";
                    Text = first + "-";
                    showing.setText(String.valueOf(Text));
                    aBoolean = false ;
                }else{
                    return;
                }
            }
        });

        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operater == null){
                    operater = "*";
                    temp = "";
                    Text = first + "*";
                    showing.setText(String.valueOf(Text));
                    aBoolean = false ;
                }else{
                    return;
                }
            }
        });

        divi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operater == null){
                    operater = "/";
                    temp = "";
                    Text = first + "/";
                    showing.setText(String.valueOf(Text));
                    aBoolean = false ;
                }else{
                    return;
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Clear();
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((first != null && operater == "/")&& second == 0){
                    Toast.makeText(MainActivity.this, "0으로 나눌 수 없어요!",Toast.LENGTH_LONG).show();
                    Clear();
                    return;

                }

                if(first == null && operater != null){
                    Toast.makeText(MainActivity.this,"첫 값을 입력해야 해요!",Toast.LENGTH_LONG).show();
                    Clear();
                    return;
                }

                if(second == null && operater != null){
                    Toast.makeText(MainActivity.this,"두 번 째 값을 입력해야 해요!",Toast.LENGTH_LONG).show();
                    Clear();
                    return;
                }

                if(operater == "+"){
                    first = first + second ;
                    showing.setText(String.valueOf(first));
                    operater = null;
                    temp = "";

                }else if(operater == "-"){
                    first = first - second ;
                    showing.setText(String.valueOf(first));
                    operater = null;
                    temp = "";

                }else if(operater == "*"){
                    first = first * second ;
                    showing.setText(String.valueOf(first));
                    operater = null;
                    temp = "";

                }else if(operater == "/"){
                    first =  first / second;
                    showing.setText(String.valueOf(first));
                    operater = null;
                    temp = "";

                }
            }
        });

    }
}

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*
     * 15 - Listener
     *  사용자의 Input을 기다리고 Input이 발생하면
     *  정해진 메소드에 사용자의 Input 이벤트를 전달함
     *  전달 받은 이벤트를 통해 메소드에서 작업을 수행 가능
     *
     */

    TextView textView ;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.TextView);



        // textView에 onClickListener를 설정하는 방법 1
        // setOnClickListener는 OnclickListener 메소드를 인스턴스로 받는다

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScondActivity.class);
                // this, 자체가 사용이 안되는 이유는 현재 이 공간이 setOnClickListener 내부의 공간이기 때문에
                //  MainActivity를 지정해줘야 한다
                startActivity(intent);
            }
        });



        // textView에 onClickListener를 설정하는 방법 2
/*
        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
             Intent intent = new Intent(MainActivity.this,ScondActivity.class);
             startActivity(intent);

            }
        };
        textView.setOnClickListener(listener);
*/



        // EditText에 TextWatcher()를 설정하는 방법 1
        // addTextChangedListener는 TextWatcher()의 메소드를 인스턴스로 받는다
        editText = findViewById(R.id.EditText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // 텍스트 변하기 전 호출되는 메소드
                Log.d("beforeTextChanged","s : "+ s);
                Log.d("beforeTextChanged","start : "+ start);
                Log.d("beforeTextChanged","count : "+ count);
                Log.d("beforeTextChanged","after : "+ after);


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 텍스트 변하는 와중에 호출되는 메소드
                Log.d("onTextChanged","s : "+ s);
                Log.d("onTextChanged","start : "+ start);
                Log.d("onTextChanged","before : "+ before);
                Log.d("onTextChanged","count : "+ count);

            }

            @Override
            public void afterTextChanged(Editable s) {
                // 텍스트 변하는 후에 호출되는 메소드
                Log.d("afterTextChanged","s : "+ s);


            }
        });

        // EditText에 TextWatcher()를 설정하는 방법 2
        /*
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        editText.addTextChangedListener(textWatcher);

         */

    }
}











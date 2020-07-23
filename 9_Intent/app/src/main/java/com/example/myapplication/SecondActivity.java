package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("LifeCycle", "2:onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Intent intent = getIntent();
        int a = intent.getIntExtra("INT_VALUE",0);
        String b = intent.getStringExtra("STR_VALUE");
        Log.d("VALUE",Integer.toString(a));
        Log.d("VALUE2",  b);

        double f = Double.valueOf("STR").doubleValue();
        int h = Integer.valueOf("STR").intValue();


        /*
        Intent intent = getIntent();
        int data = intent.getIntExtra("KEY",0); // getIntExtra(KEY,DEFAULT VALUE) 로 지정되어서 KEY값이 다르면 0이 기본으로 설정됨
        String sen = intent.getStringExtra("KEY_2"); gerStringExtra에는 DEFAULT VALUE가 없음
        Log.d("INTENT_KEY",""+data);
        Log.d("INTENT_KEY2",sen);*/


        Intent intent2 = new Intent();
        intent2.putExtra("STR","안녕하세요?");
        intent2.putExtra("STR2","감사해요");
        setResult(200,intent2);
        finish();


        /*
        Intent intent = new Intent();
        intent.putExtra("RESULT","성공");
        intent.putExtra("FAIL","실패");
        setResult(300,intent); // setResult를 통해서 resultCode가 생성되고 저장됨
        finish(); // Activity 강제 종료로 SecondActivity에서 보낸 intent를 A가 받기위해 일부러 종료함
        */


    }

    @Override
    protected void onStart() {
        Log.d("LifeCycle", "2:onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("LifeCycle", "2:onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("LifeCycle", "2:onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("LifeCycle", "2:onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("LifeCycle", "2:onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d("LifeCycle", "2:onRestart");
        super.onRestart();
    }
}

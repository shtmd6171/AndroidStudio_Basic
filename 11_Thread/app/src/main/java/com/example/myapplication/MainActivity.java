package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Thread 생성 방법 1
        /*  Thread와 Runnable을 동시에 생성하는 방식
        new  Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("runnable","1");
            }
        }).start();
        */

        // Thread 생성 방법 2
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Log.d("runnable","1");

                // runnable 객체 내부에서는 thread가 실행 중에 수행할 작업들을 적을 수 있다
                // UI Thread가 아니기 때문에 Toast를 사용하면 에러가 난다
                //Toast.makeText(MainActivity.this,"토스트",Toast.LENGTH_LONG).show();
                // 박스형 메시지 호출 Toast
                // 첫 번 째 인스턴스로 context를 받음
                // 두 번 째 인스턴스는 출력할 메시지
                // 세 번 째 인스턴스는 얼마나 오래 화면에 머무를지 정해줌 LENGTH_LONG = 1, LENGTH_SHORT = 0
            }
        };
        Thread thread = new Thread(runnable); // Thread 사용을 위해 runnable 객체를 삽입해야 함
        // new Thread(runnable).start();
        thread.start(); // 쓰레드 시작


        // UI Thread 생성 방법

        /*
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,"토스트",Toast.LENGTH_LONG).show();
            }
        });*/



        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {

                Toast.makeText(MainActivity.this,"토스트",Toast.LENGTH_LONG).show();
            }
        };
        runOnUiThread(runnable2);
        // runOnUiThread는 MainActivity 내에서 무조건 존재하고 필히 작동되므로
        // Thread를 통해 runOnUiThread를 객체로 생성하지 않고
        // .start()도 수행하지 않는다


    }

}

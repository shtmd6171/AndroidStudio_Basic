package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    int REQUEST_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("LifeCycle", "1:onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*암시적 인텐트로 구글창 띄우기
        // 시스템 요청, 외부의 애플리케이션에게 요청
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https:google.com"));
        startActivity(intent);
        */

        Intent intent2 = new Intent(Intent.ACTION_VIEW,Uri.parse("https:naver.com"));



        /*
        //명시적 인텐트는 화면전환에 주로 사용
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("KEY",5); // name이 되는 KEY값은 반드시 String 형태여야 함
        intent.putExtra("KEY_2","ANG"); // intent.putExtra가 startActivity 위에 존재해야함
        startActivityForResult(intent,REQUEST_CODE); //데이터를 받기 위해 설정함

         */

        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("INT_VALUE",100);
        intent.putExtra("STR_VALUE","STR");
        startActivityForResult(intent,REQUEST_CODE);




    }

    /*
    @Override // SecondActivity로 부터 결과 받을 받기 위한 메소드
    // 종료된 SecondActivity의 Intent가 여기의 인스턴스로 저장됨
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { //여기서 data는 SecondActivity의 intent를 가리키는 변수
        if(requestCode == REQUEST_CODE){
            if(resultCode == 200) { // SecondeActivity의 setResult로 생성된 resultCode가 여기서 인스턴스로 쓰임
                String result = data.getStringExtra("RESULT"); // SecondeActivity의 변수인 data에서 KEY가 RESULT인 intent.putExtra를 뽑아옴
                Log.d("onActivityResult",result);
            }else if(resultCode == 300) {
                String result2 = data.getStringExtra("FAIL");
                Log.d("onActivityResult",result2);
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

     */


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if(requestCode == REQUEST_CODE)
        {
            if(resultCode == 200)
            {
               String result = data.getStringExtra("STR");
               Log.d("RESULT",result);
            }else if(resultCode == 300) {
                String result2 = data.getStringExtra("STR2");
                Log.d("RESULT", result2);
            }
         }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStart() {
        Log.d("LifeCycle", "1:onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("LifeCycle", "1:onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("LifeCycle", "1:onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("LifeCycle", "1:onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("LifeCycle", "1:onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d("LifeCycle", "1:onRestart");
        super.onRestart();
    }

}

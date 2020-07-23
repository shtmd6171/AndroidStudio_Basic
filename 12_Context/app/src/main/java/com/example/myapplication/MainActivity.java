package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*
    * Context란
    * - 자신이 어떤 어플리케이션인지 알려주는 ID 역할
    * - 안드로이드 시스템 서비스에서 제공하는 기능(Toast,카메라 등)을 호출하는 역할
    * - Context의 종류
    * - (1) Application Context (앱 전체의 Context)
    * - (2) Activity Context (Activity의 Context, Activity 하나의 전체를 의미)
    * - Activity는 AppCompatActivity를 항상 상속받는 클래스로 기초적인 기능을 수행함
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = this; // Activity Context (1)
        Context context2 = MainActivity.this; // Activity Context (2)
        // this는 현재 Activity를 의미하고, context 자체가 Activity 전체를 의미함
        Context Application_context = getApplicationContext(); // Application Context

        Toast toast = Toast.makeText(context,"STR",Toast.LENGTH_LONG);
        toast.show();


        Toast.makeText(this,"hello",Toast.LENGTH_LONG).show();
        // context 칸은 Toast를 띄울 Activity를 지정하는 것이고 그 context가 현재의 Activity를 의미함
    }
}

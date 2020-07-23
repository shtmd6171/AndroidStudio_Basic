package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("LifeCyle","onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onStart() {
        Log.d("LifeCyle","onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("LifeCyle","onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("LifeCyle","onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("LifeCyle","onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("LifeCyle","onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d("LifeCyle","onRestart");
        super.onRestart();
    }



}

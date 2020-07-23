package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    /*
     * SharedPreference
     * - 간단한 데이터를 저장하기에 용이하고, 초기 설정값을 저장하는데 사용한다 (data를 KEY VALUE형식으로 저장)
     * - data/data/PakageName/shared_prefs/이름 경로에 저장된다
     * - Boolean, Integer, Float, Long, String 타입, GSON을 이용한 사용자 지정 객체도 저장 가능
     *
     * - Preference 사용을 위해 MODE를 적어야함
     * - (1) MODE_PRIVATE : 해당 app 내에서만 사용 가능
     * - (2) MODE_WORLD_READABLE : 다른 app에서 읽기가 가능
     * - (3) MODE_WORLD_WRITABLE : 다른 app에서 쓰기가 가능
     *
     * - GSON으로 객체 저장하기
     * - implementation 'com.google.code.gson:gson:2.8.5'를 추가
     * - dependencies에 추가하는 다른 방법 file -> Project Structure -> dependencies -> + -> Library Dependency
     *
     *
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String sharedPreferenceName = "SAVE_1";
        String sharedPreferenceKey = "KEY" ;

        // getSharedPreferences(이름, MODE)
        SharedPreferences sharedPreferences = getSharedPreferences(sharedPreferenceName,MODE_PRIVATE);
        // Editor를 얻어와 Editor를 통해 변화될 작업을 수행함
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // SharedPreferences에 데이터를 저장하는 방법
        // put을 통해 KEY,VALUE 형식으로 저장함
        editor.putString(sharedPreferenceKey,"안녕하세요");
        editor.commit();

        // SharedPreferences에 데이터를 불러오는 방법
        // getString(KEY,DEFAULT VALUE)
        String value = sharedPreferences.getString(sharedPreferenceKey,"실패");
        Log.d("TEST",value); // 안녕하세요

        // SharedPreferences에 있는 데이터 삭제하는 방법
        // 단일 갯수 삭제
        editor.remove(sharedPreferenceKey);
        // 전체 갯수 삭제
        editor.clear();

        editor.commit();

        String value1 = sharedPreferences.getString(sharedPreferenceKey,"실패");
        Log.d("TEST",value1); // 실패

        // GSON을 이용해 객체를 저장하는 방법
        Person person = new Person("홍길동",20);
        // editor.put 타입에는 사용자 지정타입을 지정할 수 없고
        // 객체를  JSON의 포맷으로 변경해야한다 (객체를 String 타입으로 만드는데 String이 JSON 포맷 )
        Gson gson = new Gson();
        String personJSON = gson.toJson(person);
        // personJSON에는 {"age":20,"name":"홍길동"} 의 String 타입 형식으로 저장되고 시작과 끝은 {}로 이루어짐
        // json 타입은 KEY, VALUE 타입으로 저장되는데 이때 KEY는 String 타입이다
        // age는 KEY VALUE는 20 이다.
        Log.d("TEST2",personJSON);
        String sharedPreferencePersonKey = "PERSON_KEY" ;
        editor.putString(sharedPreferencePersonKey,personJSON);
        editor.commit();

        // GSON을 이용한 객체의 데이터를 불러오는 방법
        String personString = sharedPreferences.getString(sharedPreferencePersonKey,"실패");
        // JSON 형태로 저장된 값을 다시 객체타입으로 바꿔주는 방법
        // String으로 저장된 personString을 loadedPerson에 Person.class 타입으로 다시 저장한다.
        Person loadedPerson = gson.fromJson(personString,Person.class);
        //Person loadedPerson = gson.fromJson(sharedPreferences.getString(sharedPreferencePersonKey,"실패"),Person.class);
        Log.d("TEST3",loadedPerson.name);
    }
}

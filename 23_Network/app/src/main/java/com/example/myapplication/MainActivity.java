package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.JsonArray;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    /*
     * Network
     * - 서버와 클라이언트간 통신을 위한 서비스
     * - 클라이언트는 Request를 요구하면 서버는 Request에 대한 Response가 가능
     *
     * - Request의 종류
     * - (1) GET : 정보를 요청
     * - (2) POST : 정보를 서버에게 저출
     * - (3) PUT : 정보를 갱신
     * - (4) DELETE : 정보를 삭제
     * - (5) Header : 인증 정보
     *
     * - Response Code
     * - Request에 대한 응답의 요약본
     * - (1) 200 : Success
     * - (2) 201 : Created
     * - (3) 404 : Not found
     *
     * - 서버와 클라이언트가 데이터를 주고받는 방법
     * - JSON을 사용해 데이터를 교환함
     *
     * - JSON
     * - 경량 DATA 교환방식
     * - 사람과 기계 모두 이해하기 쉬움
     * - 특정 언어에 종속되지 않음
     * - { } 로 객체를 구분하고, KEY, VALUE 방식으로 나타냄
     * - ,를 통해 데이터를 구분하고 [ ] 로 배열을 나타냄
     *
     * - Postman
     * - JSON 타입의 응답과 요청 샘플을 볼 수 있고 쉽게 구분가능한 프로그램
     *
     * - Retrofit
     * - Android network Library
     * - 쉽고 편하게 네트워크 작업이 가능 (retrofit 과 volley가 있음)
     *
     *
     */

    /*
     * # 46. Network 실습 1
     * - retrofit 라이브러리 추가
     * implementation 'com.squareup.retrofit2:retrofit:2.5.0'
     *
     * - retrofit과 함께 추가할 사항
     * - (1) Converter : JSON 형태로 전달된 데이터를 객체로 만들어주는 역할
     * implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
     * - (2) INTERNET PERMISSION : manifest에서 인터넷 사용 권한을 얻는 역할
     * <uses-permission android:name="android.permission.INTERNET" />
     *
     * ## 47. Network 실습 2
     * - 스튜디오에서 통신을 디버깅하는 라이브러리 stetho 추가
     *  implementation 'com.facebook.stetho:stetho:1.5.1'
     *  implementation 'com.facebook.stetho:stetho-okhttp3:1.4.2'
     *
     * - Stetho Debugging address
     *   chrome://inspect/@devices 로 접속
     *   패키지명 탭에서 inspect -> network 에서 어떤 응답과 요청이 왔는지 확인 가능
     *
     *
     * 
     */

    TextView textView;
    TextView textView2;
    MyService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ## stetho 라이브러리 사용을 위한 초기화
        Stetho.initializeWithDefaults(this);

        // ## okHttpClient는 retrofit 중간에 삽입하여 retrofit의 통신정보를 중간에 가로채서 확인한다
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();





        // 1-1. 통신을 준비하기 위한 Retrofit 코드
        Retrofit retrofit =  new Retrofit.Builder()
                // baseUrl이란 어느 웹페이지에서 변경되지 않는 고정적인 메인페이지를 의미
                // baseUrl의 끝에는 / 를 반드시 포함해야함
                .baseUrl("https://api.github.com/")
                // ## client로 삽입한다
                .client(okHttpClient)
                // JSON 형태로 전달된 데이터를 객체로 만들어주는 converter를 설정하는 부분
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 1-2. 통신을 준비하기 위한 Service 코드
        // baseUrl의 뒤에 오는 서비스 주소를 설정
        service = retrofit.create(MyService.class);

        textView = findViewById(R.id.text1);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestuserRepo();
            }
        });

    }
    // 통신 시작 부분을 메소드화 시켰음
    public void RequestuserRepo() {
        // 2. 통신을 시작하기 위한 코드
        // Call<타입>은 Service의 Call<타입>과 같은 타입으로 설정해야 한다
        Call<JsonArray> requestUeserRepo = service.getUserRepositories("changja88");
        // enqueue는 비동기 방식을 사용
        // 이 부분부터는 통신이 시작되는 것
        requestUeserRepo.enqueue(new Callback<JsonArray>() {
            @Override
            // 서버에게 보낸 요청이 성공했을 때
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {

            }

            @Override
            // 서버에게 보낸 요청이 실패했을 때
            public void onFailure(Call<JsonArray> call, Throwable t) {

            }
        });

        textView2 = findViewById(R.id.text2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postUser();
            }
        });

    }
    // ##
    public void postUser(){
        Call<JsonArray> postUser = service.postUser("changa88",20);
        postUser.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {

            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {

            }
        });
    }


}

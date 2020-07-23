package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    /*
     * AsyncTask
     * - MainThread를 정지시킬 수 없기 때문에 다른 Thread를 이용하고
     *   AsyncTask는 Thread를 관리하게 도와주는 역할을 함
     *
     * - 동기 : 작업이 완료될 때까지 다음 작업을 실행하지 않음 (안드로이드는 MainThread  정지가 안되므로 불가능 )
     * - 비동기 : 작업이 시작되면 다른 작업을 수행하고, 작업이 완료되면 메인스트림으로 호출됨
     *
     * -AsyncTask의 종류
     *  (1) onPreExcute : background 작업이 시작되기 전에 호출 됨 (실행 전 해야할 작업)
     *  (2) doInBackgound : background 작업 구간, doInBackgound에서 onProgressUpdate를 호출할 수 있음  (실제 스레드 작업)
     *  (3) onProgressUpdate : doInBackgound가 실행되는 도중에 호출 됨 (작업이 이루어지는 과정을 업데이트 해서 보여주기 위해)
     *  (4) onPostExcute : doInBackground가 완료되면 호출 됨 (결과 값을 받아서 작업을 수행함)
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("test1","PRE");
        //AsyncTask의 선언
        BackgroundTask backgroundTask = new BackgroundTask();
        //AsyncTask 작동 방법
        backgroundTask.execute();
        // 비동기 작업이기 때문에 Log.d가 AsyncTask와 동시에 작동한다
        Log.d("test1","POST");

    }
}

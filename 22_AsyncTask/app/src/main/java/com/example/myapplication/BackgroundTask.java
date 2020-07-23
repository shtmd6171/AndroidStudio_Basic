package com.example.myapplication;

import android.os.AsyncTask;
import android.util.Log;

/* extends된 AsyncTask<Params, Progress, Result>의 각 변수
 *  Params는  doInBackgound 에서 사용될 변수
 *  Progress는 onProgressUpdate 에서 사용될 변수
 *  Result는 onPostExcute 에서 사용될 변수이다.
 *  그렇기 때문에 AsyncTask를 사용하기 전에 사용할 작업이 어떤 역할을 하는지 파악해야 한다.
 */
public class BackgroundTask extends AsyncTask<Integer,Integer,Integer> {


    @Override
    protected void onPreExecute() {
        Log.d("TEST","onPreExecute");
        super.onPreExecute();
    }

    // 반드시 필요한 메소드
    @Override
    // Integer... integers에서 ...는 가변 변수를 의미하고 Integer 타입의 변수가 몇개 들어올지
    // 정하지 않았음을 의미
    protected Integer doInBackground(Integer... integers) {
        Log.d("TEST","doInBackground");
        int result = 0;
        for(int i = 0; i<100; i++){
            result++;
            if(i%10 == 0){
                //onProgressUpdate를 호출하는 메소드 publishProgress()
                publishProgress(i);
            }
        }
        return result;
    }

    @Override
    // ...이 가변변수이고 publishProgress()를 통해 i가 values로 넘어가는데
    // 이 때 values는 doInBackground에 의해서 정해지기 때문에 가변변수여야 한다.
    // 또한 현재 doInBackground에서 수행 한번에 하나의 값이 전달되기 때문에
    // values[0]에 원하는 값이 호출될 때마다 하나씩 들어간다.
    protected void onProgressUpdate(Integer... values) {
        Log.d("TEST",""+ values[0] + "%");
        super.onProgressUpdate(values);
    }

    @Override
    //Integer integer는 doInBackground의 최종 return 값을 받는다
    protected void onPostExecute(Integer integer) {
        Log.d("TEST",""+ integer);
        super.onPostExecute(integer);
    }
}

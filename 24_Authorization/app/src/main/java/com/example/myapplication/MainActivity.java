package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    /*
     * Authorization
     *
     *   권한의 종류
     * - (1) 정상 권한 : 사용자의 승인 없이도 manifests 등록만으로 사용 가능한 권한
     * - (2) 위험 권한 : manifests 등록 뿐 아니라 사용자의 승인도 필요함
     *
     *   권한 얻는 방법
     * - manifests 등록과 권한그룹에 따라 승인을 요청해야함
     *
     * 1. 카메라 권한 얻기
     *  <uses-permission android:name="android.permission.CAMERA"/>
     *
     *
     */

    int requestCOde = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 권한을 가졌는지 확인하는 부분
        // ( ) 안에는 수행될 Context와 권한이 있는지 확인할 permission을 넣는다
        // PackageManager.PERMISSION_GRANTED 는 permission이 승인 되었는지의 여부이다
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            // 권한을 설명해줘야할 필요가 있는지 확인하는 부분
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CAMERA)){
                // 권한을 설명하는 부분
            }else {
                // ActivityCompat.requestPermissions은 권한을 얻기 위해 실행하는 부분
                // ( ) 안에는 수행될 Context와 요청하고 싶은 권한을 String[]의 배열 형태로 넣어준다 (현재는 카메라 권한 하나이기 때문에 배열에 하나만 저장)
                // 배열의 끝에는 보낸 요청을 확인하기 위해 REQUEST_CODE를 넣어준다
                // 밑의 코드로 인해서 권한을 승인 거절 문구가 팝업됨
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},requestCOde);
            }
        }
    }

    @Override
    // ActivityCompat.requestPermissions()의 팝업창에서 사용자의 승인 or 거절한 값을 밑의 메소드로 받는다
    // 매개변수 requestCode 는 ActivityCompat.requestPermissions()에서 넘어온 requestCOde이다.
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // requestCode가 같은지 확인
        if(requestCode == this.requestCOde){
            // 권한 요청이 승인 또는 거절되었는지 확인
            // 승인 또는 거절 값이 grantResults라는 배열 값으로 들어오는데
            // 권한 요청을 여러개 했을 경우 다른 인덱스에도 값이 들어있다
            // 현재는 카메라 권한 하나만을 요청했기 때문에 [0]에 값이 들어있다
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.d("PERMISSION","승인");
            }else{
                Log.d("PERMISSION","거절");
            }

        }
    }
}

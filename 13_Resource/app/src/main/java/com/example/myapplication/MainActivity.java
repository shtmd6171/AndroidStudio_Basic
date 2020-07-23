package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /*
     * 13 - resource
     *각 핸드폰 마다의 해상도 등의 정보 https://material.io/tools/devices/
     * 기종마다 각기 다른 해상도의 이미지를 필요로하고,
     * 각 디바이스는 자동으로 자신에게 맞는 이미지를 선택한다
     * 각 디바이스에 맞는 이미지를 여러개 만들 수 없기 때문에 plugin을 사용한다
     * 우측 돋보기 -> plugins(action) -> Android Drawable Importer 설치로 plugin 설치
     * drawble -> new -> Batch drawble import -> 폴더로 해상도 별 이미지 생성
     *
     * mipmap
     * 아이콘 이미지로 다른 이미지를 설정하는 방법
     *  res 폴더 우클릭 -> new -> Image Asset
     *  Manifest에서 설정을 하고, 확인할 수 있음
     *
     *
     * values
     * layout에 작성된 것을 참고
     *
     *
     * 14 - ViewComponent
     *  뷰를 동적으로 다룸
     *  원하는 시점에 뷰를 다른 내용으로 변경할 수 있도록 하는 작업
     *
     *  values에서 string 배열을 다루는 방법
     *  - values.strings 파일에서 참고
     *
     *
     */

    ImageView imageView ;  // 각 개체를 선언
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // findViewById 메소드에 Yachung / YachungText 를 전달하면
        // xml에 해당 id를 가진 파일을 가져와 변수에 전달함
        imageView = findViewById(R.id.Yachung);
        textView = findViewById(R.id.YachungText);

        //setImageResouce()에서 ()에는 이미지의 경로와 파일 이름을 적는다
        imageView.setImageResource(R.drawable.chedoo);


        //setText()에서 ()에는 3가지 방법을 사용할 수 있다
        // 1. 직접 텍스트를 입력하는 방법
        textView.setText("채두누나");
        // 2. 메소드 내에 직접 경로(string 내에 값을 설정해둠)를 입력하는 방법
        textView.setText(R.string.Chedoo);
        // 3. 변수에 string 값을 받아 그 변수로 입력하는 방법
        String chedoo = getApplicationContext().getResources().getString(R.string.Chedoo);
        textView.setText(chedoo);

        //Resdp 정의된 string-array를 가져오는 방법
        String[] chedooArray = getApplicationContext().getResources().getStringArray(R.array.string_array);
        textView.setText(chedooArray[1]);
        Log.d("string_array",getApplicationContext().getResources().getStringArray(R.array.string_array)[4]);




    }
}

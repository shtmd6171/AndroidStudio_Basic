package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MainActivity extends AppCompatActivity {

    /*
     * 17 - Library
     *  - 특정 기능을 가지고 있는 외부 Class 또는 Function
     *
     *  1) Library는 언제 사용할까 ?
     *    - Android에서 기본적으로 제공해주지 않는 기능을 외부에서 가져오고 싶을 때
     *    - Android에서 기본적으로 제공해주나 더 편리한 기능을 사용하고 싶을 때
     *  2) Library를 사용하는 방법
     *    - Library의 홈페이지 , 깃허브에서 참조
     *
     */

    ImageView imageViewOne ;
    ImageView imageViewTwo ;
    ImageView imageViewThree ;
    ImageView imageViewFour ;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 웹 이미지를 넣는 방법
        context = this;
        imageViewOne = findViewById(R.id.image_one);
        Glide.with(context).load(Uri.parse("https://www.sciencemag.org/sites/default/files/styles/inline__699w__" +
                "no_aspect/public/dogs_1280p_0.jpg?itok=_Ch9dkfK")).into(imageViewOne);

        // option을 사용하는 방법
        imageViewTwo = findViewById(R.id.image_two);
        RequestOptions cropOption = new RequestOptions().centerCrop();
        Glide.with(context).load("https://www.sciencemag.org/sites/default/files/styles/inline__699w__" +
                "no_aspect/public/dogs_1280p_0.jpg?itok=_Ch9dkfK").apply(cropOption).into(imageViewTwo);

        imageViewThree = findViewById(R.id.image_three);
        RequestOptions cropOption2 = new RequestOptions().circleCrop();
        Glide.with(context).load("https://www.sciencemag.org/sites/default/files/styles/inline__699w__" +
                "no_aspect/public/dogs_1280p_0.jpg?itok=_Ch9dkfK").apply(cropOption2).into(imageViewThree);

        // 로컬 이미지를 사용하는 방법
        imageViewFour = findViewById(R.id.image_four);
        RequestOptions cropOption3 = new RequestOptions().optionalCircleCrop();
        Glide.with(context).load(R.drawable.ic_launcher_background).apply(cropOption2).into(imageViewFour);

    }
}

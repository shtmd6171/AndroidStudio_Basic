package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /*
     * 18 - AddView
     *  - 비슷한 포맷으로 내용물이 다른구성의 뷰 컴포넌트
     *
     *  1) AddView 구성
     *   - Inflater가 공간을 채울 layout을 얻어 XML를 채움
     *   - Layout File은 아이템 하나하나가 그려질 공간 뷰
     *   - Item list는 리스트 목록
     *   - Item은 리스트 목록의 각 객체
     *
     *  2) Addview 과제 구문
     *   Book 클래스를 생성
     *   Book (String image String name String String number){
     *   this.image = image
     *   this.name = name
     *   this.number = number }
     *
     *   MainActivity 에서
     *   ArrayList<Book>Books = new ArrayList();
     *   LinearLayout container ;
     *   LayoutInflater = layoutinflater ;
     *
     *   Book book1 = new Book(각 객체 값, - , -);
     *   Book book2 = new Book(각 객체 값, - , -);
     *
     *   container = findById(R.id.container) ;
     *   layoutinflater = Layoutinflater.from(MainActivity.this)
     *
     *   for(int i = 0; i < Books.size() ; i++) {
     *   View view = layoutinflater.inflate(R.id.addlist_view,null,false);
     *   ImageView image = view.findById(R.id.image);
     *   TextView name = view.findById(R.id.name);
     *   TextView number = view.findById(R.id.number);
     *
     *   name.setText(Books.get(i).name);
     *   number.setText(Books.get(i).numner);
     *   RequestOptions options = new RequestOptions().CircleCrop();
     *   Glide.with(MainActivity.this).load(Books.get(i).image).apply(options).into(image) ;
     *
     */

    ArrayList<String> stringList ;
    LayoutInflater layoutInflater;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stringList = new ArrayList<String>();
        stringList.add("가");
        stringList.add("나");
        stringList.add("다");
        stringList.add("라");
        stringList.add("마");
        stringList.add("바");
        stringList.add("사");
        stringList.add("아");

        // List 하나하나를 적용시킬 Layout
        container = findViewById(R.id.container);

        // XML 파일을 container 안에 그려줄 layoutflater
        layoutInflater = LayoutInflater.from(MainActivity.this);

        for(int i=0; i < stringList.size(); i++){
            // container안에 그릴 TextView를 가져오기 위해서 해당 TextView가 들어있는 layout을 inflater가 얻어 그린후 view를 생성
            View view = layoutInflater.inflate(R.layout.list_item_view,null,false);
            // layoutinflater를 이용해 layout 공간을 할당한 view 안에 들어있는 Textview의 id를 찾아서 itemText에 적용 함
            TextView itemText = view.findViewById(R.id.item_text_view);
            // textView인 itemText에 stringList가 가지고 있는 값들을 하나하나 적용시킴
            itemText.setText(stringList.get(i));

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("TEST","CLICK");
                }
            });

            // 위의 과정이 적용된 layout인 view를 MainActivity의 Layout인 container에게 적용시킴
            container.addView(view);
        }






    }
}

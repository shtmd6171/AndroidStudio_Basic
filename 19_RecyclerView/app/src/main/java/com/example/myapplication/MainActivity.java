package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /*
     * 20 - RecyclerView
     *
     * 1) RecyclerView
     * - LayoutManager를 통해 다양한 리스트 뷰를 만들 수 있음
     * - 리스트가 좌우, 일정 크기의 컬럼으로 설정, 애니메이션 효과 가능
     * - ListView보다 효율적임
     * - Header와 Footer를 위한 메소드가 없음
     * - Recycler View는 Gradle에 추가해서 사용해야 함
     *
     * - implementation 'com.android.support:recyclerview-v7:28.0.0' 를 gradle에 추가
     *
     */

    RecyclerView recyclerView ;
    ArrayList<String> itemlist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.reclycle_view);
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");
        itemlist.add("가");

        MyAdapter myAdapter = new MyAdapter(itemlist);
        // RecyclerView를 사용할때 setAdapter를 하기전에 어떤 LayoutManager를 통한 규칙을 설정할지 정한다
        // LinearLayoutManager를 사용하고 LinearLayout은 기본은 Vertical로 되어있어서,
        // 뒤에 인스턴스로 LinearLayoutManager.HORIZONTAL 을 사용하면 좌우로 움직이는 ListView를 만들 수 있다

        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);

        //GridLayoutManager를 사용하면 한 화면에 나올 내용물의 수를 정할 수 있다
        //나올 내용물의 수 뒤에는 LinearLayoutManager.HORIZONTAL,false를 설정할 수 있다

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,3);
        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,3,LinearLayoutManager.HORIZONTAL,false);

        // ListView와 마찬가지로 notifyDataSetChanged()사용이 가능하다
        myAdapter.notifyDataSetChanged();

        // recyclerView에 LayoutManager인 layoutManager을 설정한다
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);

    }
}

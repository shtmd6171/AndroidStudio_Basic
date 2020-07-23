package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    /* 21 - Pager / Tablayout
     * - 각 탭마다 page가 구성되어 있고 슬라이드를 통해 tab과 page가 변경되는 Layout
     * - tab의 이름 갯수 클릭시 작동여부를 Tablayout를 통해 관리해준다
     * - Pager는 tab 요구에 따른 Fragment로 구성된다
     *
     * - 사용을 위해 implementation'com.android.support:design:28.0.0' 적용을 해야함
     *
     *
     *
     *
     */
    ViewPager viewPager;
    TabLayout tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        tablayout = findViewById(R.id.tab_layout);

        // tablayout의 새 Tab을 만들고 Tab의 이름을 지정함
        tablayout.addTab(tablayout.newTab().setText("ONE"));
        tablayout.addTab(tablayout.newTab().setText("TWO"));
        tablayout.addTab(tablayout.newTab().setText("THREE"));

        // 매개변수로 FragmentManager를 넘겨야 하는데 이때 getSupportFragmentManager()를 넘기면  된다
        //FragmentManager fm = getSupportFragmentManager() 이기 때문
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),3);
        viewPager.setAdapter(pagerAdapter);

        //viewPager와 tablayout이 서로 연관되도록 하는 작업 1. 탭을 눌렀을 때 해당 페이저로 이동하는 방법
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            // 탭이 선택 됐을 때
            public void onTabSelected(TabLayout.Tab tab) {
                //tab.getPosition()은 각 탭에 해당하는 번호를 의미하고
                //setCurrentItem()은 viewPager에게 각 값에 해당하는 숫자에 맞는 Fragment를 보여주라는 의미
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            // 탭이 선택 안됐을 때
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            // 탭이 다시 선택 됐을 때
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        // //viewPager와 tablayout이 서로 연관되도록 하는 작업 2. 페이저를 이동시 해당 탭도 같이 이동하는 방법
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));




    }
}

package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int tabCount;

    public PagerAdapter(@NonNull FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @NonNull
    @Override
    // position에 따른 Fragment 화면 표시 여부
    public Fragment getItem(int position) {
        switch (position){
            case 0 : {
                Fragment fragmentOne = new FragmentOne();
                return fragmentOne;
            }
            case 1 : {
                Fragment fragmentTwo = new FragmentTwo();
                return fragmentTwo;
            }
            case 2 : {
                Fragment fragmentThree = new FragmentThree();
                return fragmentThree;
            }
            default:
                return null;
        }


    }

    // 페이지의 갯수
    @Override
    public int getCount() {
        return tabCount;
    }
}

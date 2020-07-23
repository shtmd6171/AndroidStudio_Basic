package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment {

    @Override
    public void onAttach(@NonNull Context context) {
        Log.d("LifeCyle","fragment2 : onAttach");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("LifeCyle","fragment2 : onCreate");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("LifeCyle","Fragment2 : onCreateView");
        return inflater.inflate(R.layout.fragment_two,container,false);
        /*
        View view = inflater.inflate(R.layout.fragment_two,container,false);
        return view;
         */
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d("LifeCyle","Fragment2 : onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d("LifeCyle","fragment2 : onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d("LifeCyle","fragment2 : onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d("LifeCyle","fragment2 : onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d("LifeCyle","fragment2 : onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d("LifeCyle","fragment2 : onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d("LifeCyle","fragment2 : onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d("LifeCyle","fragment2 : onDetach");
        super.onDetach();
    }
}

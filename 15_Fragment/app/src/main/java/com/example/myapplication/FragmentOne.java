package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


// ### 상수 BUNDLE_KEY를 사용
import static com.example.myapplication.MainActivity.BUNDLE_KEY;

// 클래스를 Fragment로 상속받아 FragmentOne이 Fragment가 됨
public class FragmentOne extends Fragment {

    @Override
    public void onAttach(@NonNull Context context) {
        Log.d("LifeCyle","Fragment1 : onAttach");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("LifeCyle","Fragment1 : onCreate");
        super.onCreate(savedInstanceState);
    }

    View view;

    // onCreateView를 생성해서 자신의 UI를 가지도록 함
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("LifeCyle","Fragment1 : onCreateView");
        // Fragment에서 등록한 XML을 작성
        // inflater : 설정한 XML을 할당 공간에 View를 통해 그려냄
        // LifeCycle이 onCreateView에 도달하게 되면
        // 할당 공간을 알고있는 FragmentOne이 inflater에게 할당 공간에 Fragment 영역을 그리게함
        view = inflater.inflate(R.layout.fragment_one,container,false);
        return view ;

    }

    // 행동이나 상호작용에 대한 Listener는 Fragment 내부에서는 onActivityCreated 를 사용하는 것이 좋다
    // Activity의 존재여부가 보장되는 사이클이기 때문
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d("LifeCyle","Fragment1 : onActivityCreated");

        // ### Activity에서 전달받은 Bundle을 꺼내는 방법
        // ### KEY 값을 상수인 BUNDLE_KEY로 설정함
        int number = getArguments().getInt(BUNDLE_KEY);
        Log.d("TEST",String.valueOf(number));

        // fragment_one의 button은 inflater를 한 view 내부에서 찾아야 함
        Button button = view.findViewById(R.id.fragment_one_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("test","CLICK");
            }
        });

        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onStart() {
        Log.d("LifeCyle","Fragment1 : onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d("LifeCyle","Fragment1 : onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d("LifeCyle","Fragment1 : onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d("LifeCyle","Fragment1 : onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d("LifeCyle","Fragment1 : onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d("LifeCyle","Fragment1 : onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d("LifeCyle","Fragment1 : onDetach");
        super.onDetach();
    }
}

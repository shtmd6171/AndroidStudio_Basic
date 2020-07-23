package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /*
     * 16 - Fragment
     *  Activity 내에서 사용자 인터페이스의 일부를 나타낸다.
     *  Activity의 일정 부분들은 Fragment로 나누어 관리하는 방식
     *  하나의 Fragment를 서로 다른 Activity에서 동일하게 사용할 수 있다.
     *  Fragment는 FragmentManager로 관리한다.
     *
     *  1) Fragment의 제약조건
     *   - Fragment는 Activity 내부에 포함되어 있어야한다.
     *    (Fragment는 Activity와 다르게 독립적으로 존재 불가능)
     *   - Acitivity의 수명 주기에 직접적으로 영향을 받는다.
     *   - 모든 Fragment가 UI를 가지고 있어야 하는 것은 아니다.
     *
     *  2) Framgment에 존재하는 LifeCycle
     *   - onAttach : Fragment가 Activity와 연관되어 있는 경우 호출이 된다. Activity가 전달됨 (onCreate())
     *   - onCreateView : Fragment가 자신의 UI를 처음으로 생성할 때 호출됨 (onCreate())
     *   - onActivityCreated : Fragment가 Activity의 onCreate()가 반환되면 호출됨 (onCreate())
     *   - onDestroyView : Fragment와 연관되어 있는 뷰 계층이 제거되는 중일 때 호출(연관된 Activity의 호출이 사라지는 중) (onDestroy())
     *   - onDetach : Fragment가 Activity와 연결이 끊어지는 중일 때 호출 (onDestroy())
     *
     *  3) Fragment 생성 방법
     *
     *   (1) Fragment를 특정 뷰에 할당하는 방법
     *      - Frgament를 동적으로 사용(다른 Fragment를 교체, 제거, 다중사용 등)하고 싶을 때 유리함
     *
     *      1. Fragment의 화면이 될 XML을 생성한다.
     *      2. Fragment에게 화면을 할당할 XML 공간을 지정한다
     *      3. Fragment를 상속받은 class를 할당하고 onCreateView 를 Overriding 한다.
     *      4. View를 생성하고 inflater.inflate 를 이용해, 2의 공간을 채울 1을 설정한다.
     *      5. 2를 설정한 Activity에서 FragmentManager를 생성하고 getSupportFragmentManager()를 설정한다.
     *      6. FragmentTransaction을 fragmentManager.beginTrascation() 을 통해 실행시킨다.
     *      7. Transaction의 add or replace를 통해 2에서 설정한 공간, 그리고 3을 설정한 Fragment를 지정한다.
     *      8. Transaction의 commit을 통해 실행한다.
     *
     *   (2) Fragment를 XML에 등록하는 방법 ## 25. fragment 실습 3
     *      1. Fragment의 화면이 될 XML을 생성한다.
     *      2. Fragment에게 화면을 할당할 XML 공간을 <fragment>로 새로 만든다.
     *      3. Fragment를 상속받은 class를 할당하고 onCreateView 를 Overriding 한다.
     *      4. View를 생성하고 inflater.inflate 를 이용해, 2의 공간을 채울 1을 설정한다.
     *      3. 2에서 지정한 <fragment>의 id와 name(3의경로)을 지정한다.
     *
     *  4) Activity가 Fragment에게 값을 전달하는 방법 ### 26. fragment 실습 4
     *    - Activity에서 Activity로 값을 전달할 때는 Intent의 intent.putExtra , intent.get<>Extra를 사용했지만
     *      Activity가 Fragment와 값을 주고 받기 위해서는 Bundle을(bundle.put<>(), getArguments().get<>()) 사용한다.
     *
     *      전달하는 곳
     *      Fragment fragment = new fragment();
     *      Bundle bundle = new Bundle();
     *      bundle.put{ Int | Double | String etc}("KEY",VALUE);
     *      fragment.setArguments(bundle);
     *      fragmentTransaction.add(R.id.container, fragment);
     *
     *      전달 받는 곳
     *      int number = getArguments().get{ Int | Double | String etc}("KEY");
     *

     */
    // ### KEY 값을 더 직관적으로 활용하는 방법
    public static final String BUNDLE_KEY = "bundle_key";

    FragmentManager fragmentManager ;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("LifeCyle","Activity : onCreate");

        // getSupportFragmentManager()의 메소드는 Activity 내부에서 선언해줘야 함
        // getSupportFragmentManager()는 FragmentManager가 가진 메소드 .beginTransaction()를 사용할 수 있게 한다
        fragmentManager = getSupportFragmentManager();

        // FragmentTransaction 클래스는 수행내용을 적용하는 add,commit을 지원하고
        // 이를 수행하기 위해 fragmentTransaction을 생성한다.
        // fragmentManager가 트랜잭션을 시작하는 메소드 .beginTransaction()를 사용해
        // fragmentTransaction 이 동작하도록 한다.
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //  ### FragmentOne()에게 값을 전달하는 법
        Fragment fragmentOne = new FragmentOne();
        Bundle bundle = new Bundle();
        //  ### putExtar가 아닌 값의 종류에 따라 put{Int | Double | String  etc}를 사용함
        // ### KEY 값을 상수인 BUNDLE_KEY로 설정함
        bundle.putInt(BUNDLE_KEY,10);
        //  ### bundle을 fragment에게 전달하는 메소드 setArguments를 사용함
        fragmentOne.setArguments(bundle);


        // FragmentTransaction의 add를 통해, container의 공간을 FragmentOne()에게 그리게 하고
        // FragmentOne()은 onCreateView를 통해 알고 있는 container의 공간을 fragment_one이 가질 수 있게 함
        fragmentTransaction.add(R.id.container, fragmentOne); // ### fragmentOne 은 Bundle 값을 담은 FragmentOne()임
        // FragmentTransaction은 commit이 이루어지면 재사용할 수 없음 !
        fragmentTransaction.commit();


        button = findViewById(R.id.Button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
                // FragmentTransaction의 replace를 통해, container의 공간을 FragmentTwo()에게 그리게 하고
                // FragmentTwo()는 onCreateView를 통해 알고 있는 container의 공간을 fragment_two로 교체함
                fragmentTransaction2.replace(R.id.container, new FragmentTwo());
                fragmentTransaction2.commit();


            }
        });

    }

    @Override
    protected void onStart() {
        Log.d("LifeCyle","Activity : onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("LifeCyle","Activity : onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("LifeCyle","Activity : onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("LifeCyle","Activity : onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("LifeCyle","Activity : onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d("LifeCyle","Activity : onRestart");
        super.onRestart();
    }
}

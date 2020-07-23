package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /*
     *19-ListView
     *
     * AddView 방식의 문제
     * -AddView가 설정되는 작업이 끝날 때까지 다른 작업을 실행할 수 없음 (for문 loop)
     * -모든 item view 전체를 다 그려낸다
     * -Adapter를 이용하면 모든 item view를 그려내는 것이 아니라
     * -현재 보여질 화면의 view와 예비로 필요한 view만을 동적으로 그려낸다
     * -화면 밖으로 밀려난 view는 adapter를 통해 다시 화면이 그려진 후 다음 view로 등장한다 (재활용)
     *
     * 1) Adapter의 장점
     * -(1) 지연로딩 : 필요한 부분만을 그려내는 기능, Inflating 효율을 높임
     * -(2) 데이터 변화를 다시 적용하는데 용이함 ### 36. ListView 실습 3
     *
     * 2) Adapter의 종류
     * - 모든 Adpater는 base Adapter를 상속받아 생성한다
     * -(1) base Adapter
     * -(2) cursor Adapter : DB에 특화된 Adapter
     * -(3) Array Adapter : ArrayList에 특화된 Adapter
     *
     * 3) Header 와 Footer ## 35. ListView 실습 2
     * - 헤더나 푸터를 사용하여 리스트뷰의 상, 하단에 새로운 영역을 붙일 수 있음
     * - 기존의 ListView와 마찬가지로 inflater를 이용해 붙여준다
     * - 헤더뷰와 푸터뷰 내에는 내용물이 반드시 있어야한다.
     *
     *
     *
     */

    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inflater에게 공간을 내줄 ListView의 위치를 설정
        ListView listView = findViewById(R.id.list_view);
        list.add("가");
        list.add("나");
        list.add("가");
        list.add("가");
        list.add("가");
        list.add("가");
        list.add("가");
        list.add("가");
        list.add("가");
        list.add("가");
        list.add("가");
        list.add("가");
        list.add("가");
        list.add("가");
        list.add("가");
        list.add("가");
        list.add("가");
        list.add("가");
        list.add("가");
        list.add("가");

        // ## inflater가 그림을 그려낼 공간인 context를 지정
        LayoutInflater inflater = LayoutInflater.from(this);
        // ## View로 각 header와 Footer의 XML을 지정
        View header = inflater.inflate(R.layout.header_view,null,false);
        View footer = inflater.inflate(R.layout.footer_view,null,false);

        // ## listView 내에서 addHeadr/FooterView를 제공한다
        listView.addHeaderView(header);
        listView.addFooterView(footer);

        // myAdapter의 생성자의 context와 값을 설정한 list를 설정함
        final MyAdapter myAdapter = new MyAdapter(MainActivity.this, list);

        // ### header를 클릭하면 list 첫번째 인덱스를 "가"로 교체함
        // ### 이런 방식으로 데이터 변화를 다시 적용하는데 용이함
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ### 값은 변경되었으니 실제 화면에서는 바뀐 값이 갱신 되지 않았음 (Log.d 상에서만 변경)
                list.set(1,"가");
                Log.d("TEST",list.get(1));
                // ### notifiyDatasetChanged() 메소드는 데이터의 변경상태를 체크하고 변경되었을 시 갱신해주는 역할을 함
               myAdapter.notifyDataSetChanged();

            }
        });

        // Adapter에게 할당될 XML 공간을 맡기는 역할
        listView.setAdapter(myAdapter);

    }

    //BaseAdapter를 상속 받으면 getCount,Item,ItemId,View를 클래스 내부에 구현해줘야 함
    public class MyAdapter extends BaseAdapter {

        private ViewHoder viewHoder;
        private LayoutInflater layoutInflater ;
        private ArrayList<String> itemlist ;

        // Context와 inflate에 필요한 ArrayList를 생성자로 선언
        public MyAdapter(Context context, ArrayList<String> itemlist) {
            this.itemlist = itemlist;
            // 이 클래스의 Inflater가 그려내는 작업을 할 공간을 외부의 Context를 통해 받아냄
            this.layoutInflater = LayoutInflater.from(context);
        }

        // 내가 그려낼 리스트뷰의 총 갯수를 알려 리턴하는 역할
        @Override
        public int getCount() {
            return itemlist.size();
        }

        // Adapter가 리스트로부터 가져올 실제 값을 리턴하는 역할
        // position은 리스트뷰의 순서를 의미
        // 리스트가 ArrayList의 Stiring 타입이기 때문에, 메소드의 반환타입을 리스트 타입에 맞게 바꿔준다
        @Override
        public String getItem(int position) {
            return itemlist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        // inflater를 가져와 XML의 View들을 데이터와 결합하고 공간을 할당한 XML에 addview를 하는
        // 메인 작업이 이루어지는 공간
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // inflater를 통해 할당받은 공간에 채워넣을 XML을 지정하고 그린 결과를 view에 저장함
            // (여기서 할당받은 공간은 layoutInflater = LayoutInflater.from(context)임을 통해서 지정됨)
            View view = convertView ;
            // ViewHolder인 저장소에 view가 하나도 존재하지 않으면
            if(view == null){
                // ViewHolder를 생성하고
                viewHoder = new ViewHoder();
                view = layoutInflater.inflate(R.layout.list_item_view,null,false);
                // inflate된 layout인 list_item_view의 내용물 view를 저장소 공간인 ViewHolder의 내용물 저장함
                viewHoder.textView = view.findViewById(R.id.item_view_text);
                //setTag를 통해 view의 내용물을 viewHolder에 저장함
                view.setTag(viewHoder);
            }else{
                // 만약 viewholder가 비어있지 않다면, 재활용하도록 저장된 값을 가져옴
                viewHoder = (ViewHoder) view.getTag();
            }
            // 저장되어 있는 빈 값에 실제 값을 getItem의 ArrayList의 각 값으로 채워주는 역할
            viewHoder.textView.setText(getItem(position));

            return view ;
        }

        // ViewHoder는 사용된 View들을 채워지기 전 상태로 저장하는 역할
        class ViewHoder{
            // activity_main의 ListVeiw의 공간을 채울 list_item_view의 view가 textview 하나라서 하나만 선언
            public TextView textView = null ;
        }
    }


}








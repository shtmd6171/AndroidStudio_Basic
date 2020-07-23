package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<String> itemlist;

    public MyAdapter(ArrayList<String> itemlist) {
        this.itemlist = itemlist;
    }

    @NonNull
    @Override
    // View를 inflate 하여 만들어준 내용을 ViewHolder 생성자의 매개변수로 넣어 return 시켜준다
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // parent.getContext()를 이용해서 Context를 생성자로 넘겨주지 않고 생성이 가능함
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // ListView에서는 생성자를 통해 Context를 받았지만, 여기서는 받지 않았으므로 inflate의 ViewGroup을 parent로 지정해야줘야 함
        View view = layoutInflater.inflate(R.layout.item_view,parent,false);
        // view를 넣은 ViewHolder를 리턴함
        return new ViewHolder(view);
    }

    @Override
    // View안에 필요한 데이터를 채워주는 작업을 하는 구역
    // 매개변수의 ViewHolder는 클래스로 만든 ViewHolder이고 이 내부에 TextView를 생성했었다
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(itemlist.get(position));
    }

    @Override
    public int getItemCount() {
        return itemlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

            TextView textView ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item);
        }
    }
}

package com.dinesh.sheduleit.parcelable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dinesh.sheduleit.R;
import com.dinesh.sheduleit.databinding.ActivityParcelableBinding;

import java.util.ArrayList;
import java.util.List;

public class ParcelableActivity extends AppCompatActivity {

    private ActivityParcelableBinding binding;
    private List<MyParcelableModel> data=new ArrayList<>();
    MyAdapter adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_parcelable);

        init();
    }

    private void init() {
        setData();

        recyclerView=binding.recyclerView;
        adapter=new MyAdapter(data, this, new MyAdapter.MyItemClick() {
            @Override
            public void onClickk(View view, int pos) {
                Intent i=new Intent(getApplicationContext(),ShowParcelableDataActivity.class);
                i.putExtra("MyItems",data.get(pos));
                startActivity(i);
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private List<MyParcelableModel> setData(){
        data.add(new MyParcelableModel(R.drawable.ic_android,"hi","line1"));
        data.add(new MyParcelableModel(R.drawable.ic_android,"hello","line2"));
        data.add(new MyParcelableModel(R.drawable.ic_android,"hi","line3"));
        data.add(new MyParcelableModel(R.drawable.ic_android,"hello","line4"));


        return data;
    }
}
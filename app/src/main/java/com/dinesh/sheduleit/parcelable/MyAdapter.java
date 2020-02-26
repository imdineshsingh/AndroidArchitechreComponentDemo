package com.dinesh.sheduleit.parcelable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dinesh.sheduleit.R;
import com.dinesh.sheduleit.databinding.RecylerItemBinding;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<MyParcelableModel> data;
    private Context mContext;
    private MyItemClick myItemClick;

    public MyAdapter(List<MyParcelableModel> data, Context mContext,MyItemClick myItemClick) {
        this.data = data;
        this.mContext = mContext;
        this.myItemClick=myItemClick;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v  =  LayoutInflater.from(mContext).inflate(R.layout.recyler_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        if (data!=null){

            holder.binding.line1.setText(data.get(position).getmText1());
            holder.binding.line2.setText(data.get(position).getmText2());
            Glide.with(mContext).load(data.get(position).getImage()).into(holder.binding.image);

            holder.binding.linearItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myItemClick.onClickk(v,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private RecylerItemBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=RecylerItemBinding.bind(itemView);
        }
    }

    public interface MyItemClick{
        void onClickk(View view,int pos);
    }
}

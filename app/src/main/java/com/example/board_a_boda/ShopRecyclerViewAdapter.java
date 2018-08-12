package com.example.board_a_boda;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ShopRecyclerViewAdapter extends RecyclerView.Adapter<ShopRecyclerViewAdapter.MyViewHolder>
{
    Context mContext;
    List<ShopItem> mData;

    public ShopRecyclerViewAdapter(Context mContext, List<ShopItem> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v= LayoutInflater.from(mContext).inflate(R.layout.item_shop,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_name.setText(mData.get(position).getSuper_name());
        holder.tv_motto.setText(mData.get(position).getSuper_motto());
        holder.img.setImageResource(mData.get(position).getPhoto());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder
    {
        private TextView tv_name;
        private TextView tv_motto;
        private ImageView img;



        public MyViewHolder(View itemView)
        {
            super(itemView);

            tv_name = (TextView) itemView.findViewById(R.id.super_name);
            tv_motto =(TextView) itemView.findViewById(R.id.super_motto);
            img = (ImageView)itemView.findViewById(R.id.super_logo);


        }

    }
}

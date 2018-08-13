package com.example.board_a_boda;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CartItemRecyclerViewAdapter extends RecyclerView.Adapter<CartItemRecyclerViewAdapter.MyViewHolder> {
    Context mContext;
    List<CartItem> mData;

    public CartItemRecyclerViewAdapter(Context mContext, List<CartItem> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v= LayoutInflater.from(mContext).inflate(R.layout.cart_item,parent,false);
        CartItemRecyclerViewAdapter.MyViewHolder vHolder = new CartItemRecyclerViewAdapter.MyViewHolder(v);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        holder.tv_itname.setText(mData.get(position).getItem_name());
        holder.tv_itemprice.setText(mData.get(position).getItem_price());
        holder.tv_itnumber.setText(mData.get(position).getItem_number());
        holder.tv_photo.setImageResource(mData.get(position).getPhoto());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_itname;
        private TextView tv_itemprice;
        private TextView tv_itnumber;
        private ImageView tv_photo;

        public MyViewHolder(View itemView) {

            super(itemView);

            tv_itname = (TextView) itemView.findViewById(R.id.item_name);
            tv_itemprice =(TextView) itemView.findViewById(R.id.item_price);
            tv_itnumber =(TextView) itemView.findViewById(R.id.number);
            tv_photo =(ImageView)itemView.findViewById(R.id.item_logo);


        }
    }
}

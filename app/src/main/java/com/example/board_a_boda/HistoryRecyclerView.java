package com.example.board_a_boda;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HistoryRecyclerView extends RecyclerView.Adapter<HistoryRecyclerView.MyViewHolder> {

    Context mContext;
    List<HistoryItem> mData;


    public HistoryRecyclerView(Context mContext, List<HistoryItem> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }




    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v= LayoutInflater.from(mContext).inflate(R.layout.item_history,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);

        return vHolder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_name.setText(mData.get(position).getSuper_name_text());
        holder.tv_date.setText(mData.get(position).getDate_text());
        holder.tv_receipt.setText(mData.get(position).getReceipt_text());
        holder.img.setImageResource(mData.get(position).getPhoto());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_name;
        private TextView tv_date;
        private TextView tv_receipt;
        private ImageView img;


        public MyViewHolder(View itemView) {
           super(itemView);

            tv_name = (TextView) itemView.findViewById(R.id.super_name_text);
            tv_date =(TextView) itemView.findViewById(R.id.date_text);
            tv_receipt =(TextView) itemView.findViewById(R.id.receipt_text);
            img =(ImageView)itemView.findViewById(R.id.super_logo);


        }
    }
}

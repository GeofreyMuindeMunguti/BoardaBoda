package com.example.board_a_boda;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import android.R.layout;

public class ShoppedItemRecyclerViewAdapter extends RecyclerView.Adapter<ShoppedItemRecyclerViewAdapter.MyViewHolder> {
    Context mContext;
    List<ShoppedItem> mData;
    String string;

    public ShoppedItemRecyclerViewAdapter(Context mContext, List<ShoppedItem> mData) {
        this.mContext = mContext;
        this.mData =mData;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v= LayoutInflater.from(mContext).inflate(R.layout.shopped_item,parent,false);
        ShoppedItemRecyclerViewAdapter.MyViewHolder vHolder = new ShoppedItemRecyclerViewAdapter.MyViewHolder(v);



        return vHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position)
    {
        holder.tv_itname.setText(mData.get(position).getItem_name());
        holder.tv_itemprice.setText(mData.get(position).getItem_price());
        holder.tv_itnumber.setText(mData.get(position).getItem_number());
        holder.tv_photo.setImageResource(mData.get(position).getPhoto());



    }
    interface ShoppingData
    {




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
        private Button btn_buy;



        public MyViewHolder(View itemView) {

            super(itemView);

            tv_itname =  itemView.findViewById(R.id.item_name);
            tv_itemprice = itemView.findViewById(R.id.item_price);
            tv_itnumber = (TextView) itemView.findViewById(R.id.number);
            tv_photo = (ImageView) itemView.findViewById(R.id.item_logo);
            btn_buy = (Button) itemView.findViewById(R.id.buy);




//                final ArrayList<String> list = new ArrayList<String>();


            //mData.get()
            // final String itemname = tv_itname.getText().toString();

            btn_buy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btn_buy.setText("Added");
//                        int position = (int) v.getTag();
//                        mData.get(position);

                    // String itemname = mData.get(position).getItem_name();

                    // shoppinglist.add(itemname);

                    // int i = 0;
                    //Log.d("values", shoppinglist.get(position));

                    // for (String s : shoppinglist) {
                    //     Toast.makeText(mContext, s, Toast.LENGTH_SHORT).show();
                    // }

                }
            });

////
////                 to get i th element
////                  int i=0;
//            Log.d("value", list.get(i));
        }


    }


}





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

public class CartItemRecyclerViewAdapter extends RecyclerView.Adapter<CartItemRecyclerViewAdapter.MyViewHolder> {
    Context mContext;
    List<CartItem> mData;
    String string;

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
    public void onBindViewHolder(final MyViewHolder holder, final int position)
    {
        holder.tv_itname.setText(mData.get(position).getItem_name());
        holder.tv_itemprice.setText(mData.get(position).getItem_price());
        holder.tv_itnumber.setText(mData.get(position).getItem_number());
        holder.tv_photo.setImageResource(mData.get(position).getPhoto());


        final ArrayList<String> shoppinglist = new ArrayList();
        holder.btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.btn_buy.setText("Added");
                holder. btn_buy.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.button_background));

                CartItem i=   mData.get(position);
                String name = mData.get(position).getItem_name();
                shoppinglist.add(name);



                Log.d("", String.valueOf(i));
             //Toast.makeText(mContext,"Added "+name+" to cart",Toast.LENGTH_SHORT).show();



                for (String s : shoppinglist){
                    Log.d("My array list content: ", s);
                    //Toast.makeText(mContext, s, Toast.LENGTH_SHORT).show();
                }
               // String string = shoppinglist.toString();

            }
            //String string = shoppinglist.toString();

        });   string = shoppinglist.toString();
//        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);


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





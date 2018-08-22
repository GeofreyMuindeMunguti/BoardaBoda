package com.example.board_a_boda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShoppedActivity extends AppCompatActivity {
    private List<ShoppedItem> shoppedItems;
    private RecyclerView recyclerView;
    private String ToShoppeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopped);



        ToShoppeList = getIntent().getStringExtra("toshoppe");
        Toast.makeText(ShoppedActivity.this, ToShoppeList + " ",Toast.LENGTH_SHORT).show();
        //Log.d("To shop",ToShoppeList);

        shoppedItems = new ArrayList<>();
        recyclerView = findViewById(R.id.cart_recyclerview);
        //String name = getIntent().getStringExtra();

        shoppedItems.add(new ShoppedItem(ToShoppeList,ToShoppeList,ToShoppeList,R.drawable.milk));








        ShoppedItemRecyclerViewAdapter myadapter = new ShoppedItemRecyclerViewAdapter(ShoppedActivity.this,shoppedItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(ShoppedActivity.this));
        recyclerView.setAdapter(myadapter);

    }
}

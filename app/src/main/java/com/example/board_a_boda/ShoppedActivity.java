package com.example.board_a_boda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ShoppedActivity extends AppCompatActivity {
    private List<ShoppedItem> shoppedItems;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopped);


        shoppedItems = new ArrayList<>();
        recyclerView = findViewById(R.id.cart_recyclerview);

        shoppedItems.add(new ShoppedItem("Omo"," 100","200",R.drawable.omo));
        shoppedItems.add(new ShoppedItem("Milk"," 50","171",R.drawable.milk));





        ShoppedItemRecyclerViewAdapter myadapter = new ShoppedItemRecyclerViewAdapter(ShoppedActivity.this,shoppedItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(ShoppedActivity.this));
        recyclerView.setAdapter(myadapter);

    }
}

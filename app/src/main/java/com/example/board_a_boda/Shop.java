package com.example.board_a_boda;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Shop extends Fragment {
    public ImageView goshopping;

    private RecyclerView myRecyclerView;
    private List<ShopItem> lstShopItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.shop, container, false);
        myRecyclerView =(RecyclerView) rootView.findViewById(R.id.shop_recyclerview);
        ShopRecyclerViewAdapter recyclerViewAdapter = new ShopRecyclerViewAdapter(getContext(),lstShopItem);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);




        return rootView;



    }
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        lstShopItem = new ArrayList<>();
        lstShopItem.add(new ShopItem("Uchumi","Huduma kwa wote", R.drawable.uchumilogo));
        lstShopItem.add(new ShopItem("Naivas","Saves you money", R.drawable.naivas));
        lstShopItem.add(new ShopItem("Nakumatt","Here for you", R.drawable.nakumattlogo));
        lstShopItem.add(new ShopItem("Tuskys","All you need", R.drawable.tuskyslogo));
        lstShopItem.add(new ShopItem("Uchumi","Huduma kwa wote", R.drawable.uchumilogo));
        lstShopItem.add(new ShopItem("MassMatt","Forever full", R.drawable.logo));

        lstShopItem.add(new ShopItem("Naivas","Saves you money", R.drawable.naivas));
        lstShopItem.add(new ShopItem("Nakumatt","Here for you", R.drawable.nakumattlogo));
        lstShopItem.add(new ShopItem("Tuskys","All you need", R.drawable.tuskyslogo));
        lstShopItem.add(new ShopItem("Uchumi","Huduma kwa wote", R.drawable.uchumilogo));
        lstShopItem.add(new ShopItem("MassMatt","Forever full", R.drawable.logo));

        lstShopItem.add(new ShopItem("Naivas","Saves you money", R.drawable.naivas));
        lstShopItem.add(new ShopItem("Nakumatt","Here for you", R.drawable.nakumattlogo));
        lstShopItem.add(new ShopItem("Tuskys","All you need", R.drawable.tuskyslogo));
        lstShopItem.add(new ShopItem("Uchumi","Huduma kwa wote", R.drawable.uchumilogo));
        lstShopItem.add(new ShopItem("MassMatt","Forever full", R.drawable.logo));




    }



}


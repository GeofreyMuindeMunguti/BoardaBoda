package com.example.board_a_boda;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class History extends Fragment {
    private RecyclerView myRecyclerView;
    private List<HistoryItem> lstHistoryItem;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.history, container, false);

        myRecyclerView =(RecyclerView) rootView.findViewById(R.id.history_recyclerview);
        HistoryRecyclerView recyclerViewAdapter = new HistoryRecyclerView(getContext(),lstHistoryItem);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);

        return rootView;
    }
//    GoogleMap mGoogleMap;
//    MapView mMapView;
//    View mView;
//    private Marker myMarker;
////    mMapView =(MapView) mView.findViewById(R.id.map);
//
//      if(mMapView!=null){
//        mMapView.onCreate(null);
//        mMapView.onResume();
//        mMapView.getMapAsync(this);
//    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstHistoryItem = new ArrayList<>();
        lstHistoryItem.add(new HistoryItem("Naivas","7/7/2018","RCT:##QDST",R.drawable.naivas));
        lstHistoryItem.add(new HistoryItem("Naivas","6/7/2018","RCT:##QDST",R.drawable.naivas));
        lstHistoryItem.add(new HistoryItem("Naivas","5/7/2018","RCT:##QDST",R.drawable.naivas));
        lstHistoryItem.add(new HistoryItem("Tuskys","4/7/2018","RCT:##QDST",R.drawable.tuskyslogo));
        lstHistoryItem.add(new HistoryItem("Nakumatt","2/7/2018","RCT:##QDST",R.drawable.nakumattlogo));
        lstHistoryItem.add(new HistoryItem("Tuskys","28/6/2018","RCT:##QDST",R.drawable.tuskyslogo));

        lstHistoryItem.add(new HistoryItem("Naivas","27/6/2018","RCT:##QDST",R.drawable.naivas));
        lstHistoryItem.add(new HistoryItem("Naivas","25/6/2018","RCT:##QDST",R.drawable.naivas));
        lstHistoryItem.add(new HistoryItem("Naivas","5/6/2018","RCT:##QDST",R.drawable.naivas));
        lstHistoryItem.add(new HistoryItem("Tuskys","4/6/2018","RCT:##QDST",R.drawable.tuskyslogo));
        lstHistoryItem.add(new HistoryItem("Nakumatt","2/6/2018","RCT:##QDST",R.drawable.nakumattlogo));
        lstHistoryItem.add(new HistoryItem("Tuskys","28/5/2018","RCT:##QDST",R.drawable.tuskyslogo));

        lstHistoryItem.add(new HistoryItem("Naivas","7/5/2018","RCT:##QDST",R.drawable.naivas));
        lstHistoryItem.add(new HistoryItem("Naivas","6/5/2018","RCT:##QDST",R.drawable.naivas));
        lstHistoryItem.add(new HistoryItem("Naivas","5/5/2018","RCT:##QDST",R.drawable.naivas));
        lstHistoryItem.add(new HistoryItem("Tuskys","4/5/2018","RCT:##QDST",R.drawable.tuskyslogo));
        lstHistoryItem.add(new HistoryItem("Nakumatt","2/5/2018","RCT:##QDST",R.drawable.nakumattlogo));
        lstHistoryItem.add(new HistoryItem("Tuskys","28/4/2018","RCT:##QDST",R.drawable.tuskyslogo));




    }
}


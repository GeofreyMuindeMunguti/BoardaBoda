package com.example.board_a_boda;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class TabView extends Fragment implements OnMapReadyCallback {
    GoogleMap mGoogleMap;
    MapView mMapView;
    View mView;
    private Marker myMarker;

    public TabView()
    {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.mapview, container, false);

        return mView;

       // mGoogleMap.setOnMarkerClickListener(Marker marker);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

      mMapView =(MapView) mView.findViewById(R.id.map);

      if(mMapView!=null){
          mMapView.onCreate(null);
          mMapView.onResume();
          mMapView.getMapAsync(this);
      }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        MapsInitializer.initialize(getContext());
        mGoogleMap=googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);



        Marker marker=googleMap.addMarker(new MarkerOptions().position(new LatLng(-1.219222, 36.888219)).title("Thika Road Mall").snippet("Come shop with us!!"));
        //googleMap.setOnMarkerClickListener(this);
        CameraPosition Geff = CameraPosition.builder().target(new LatLng(-1.219222, 36.888219)).zoom(16).bearing(0).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Geff));

        Marker marker2=googleMap.addMarker(new MarkerOptions().position(new LatLng(-1.232538, 36.878551)).title("Garden City Mall").snippet("Come shop with us!!"));
        //googleMap.setOnMarkerClickListener(this);
        CameraPosition Geff2 = CameraPosition.builder().target(new LatLng(-1.232538, 36.878551)).zoom(16).bearing(0).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Geff2));


    }
    //@Override

}

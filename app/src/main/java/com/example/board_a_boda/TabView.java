package com.example.board_a_boda;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class TabView extends Fragment implements OnMapReadyCallback,GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        com.google.android.gms.location.LocationListener , GoogleMap.OnMarkerClickListener {
    private View view;
    SupportMapFragment supportMapFragment;
    LocationRequest mLocationRequest;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    GoogleMap mGoogleMap;
    public static final int PERMISSIONS_REQUEST_LOCATION = 100;
    private Toolbar toolbar;

    //GoogleMap mGoogleMap;
    MapView mMapView;
    View mView;
    Marker marker2;
    Marker myLoc;
    //private Marker myMarker;

    public TabView()
    {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.mapview, container, false);

        return mView;




       // mGoogleMap.setOnMarkerClickListener(Marker marker);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //super.onViewCreated(view, savedInstanceState);

        init();

      mMapView =(MapView) mView.findViewById(R.id.map);

      if(mMapView!=null){
          mMapView.onCreate(null);
          mMapView.onResume();
          mMapView.getMapAsync(this);
      }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void init() {
//        toolbar = view.findViewById(R.id.toolbar);
        //toolbar.setTitle("Your Location");
       // toolbar.setTitleTextColor(Color.WHITE);




        //supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        //supportMapFragment.getMapAsync(this);
    }




    @Override
    public void onConnected(@Nullable Bundle bundle) {

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this.getActivity(),
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED)
        {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }

    }
    private void checkPermission()
    {
        if (ContextCompat.checkSelfPermission(this.getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED)
        {

            if (ActivityCompat.shouldShowRequestPermissionRationale(TabView.this.getActivity(),
                    android.Manifest.permission.ACCESS_FINE_LOCATION))
            {
                new AlertDialog.Builder(TabView.this.getActivity())
                        .setTitle("Location Permission Needed")
                        .setMessage("This app needs the Location permission, please accept to use location functionality")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {

                                ActivityCompat.requestPermissions(TabView.this.getActivity(),
                                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                                        PERMISSIONS_REQUEST_LOCATION);
                            }
                        })
                        .create()
                        .show();


            } else
            {

                ActivityCompat.requestPermissions(this.getActivity(),
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        PERMISSIONS_REQUEST_LOCATION);
            }
        }
    }

//    protected synchronized void buildGoogleApiClient()
//    {
//        mGoogleApiClient = new GoogleApiClient.Builder(this.getActivity())
//                .addConnectionCallbacks(this)
//                .addOnConnectionFailedListener(this)
//                .addApi(LocationServices.API)
//                .build();
//        mGoogleApiClient.connect();
//    }


    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        switch (requestCode)
        {
            case PERMISSIONS_REQUEST_LOCATION:
            {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {

                    if (ContextCompat.checkSelfPermission(this.getActivity(),
                            android.Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED)
                    {

                        if (mGoogleApiClient == null)
                        {
                           // buildGoogleApiClient();
                        }
                        mGoogleMap.setMyLocationEnabled(true);
                    }

                } else
                {

                    Toast.makeText(this.getActivity(), "permission denied by user", Toast.LENGTH_LONG).show();
                }
                return;
            }

        }
    }

    @Override
    public void onPause()
    {
        super.onPause();
        if (mGoogleApiClient != null)
        {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }
    }

    @Override
    public void onLocationChanged(Location location)
    {
        mLastLocation = location;
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }

       // Place current location marker
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Location");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
        mCurrLocationMarker = mGoogleMap.addMarker(markerOptions);
        //move map camera and we can also set zoom level
        CameraPosition Geffaa = CameraPosition.builder().target( (latLng)).zoom(16).tilt(45).build();
        mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Geffaa));

//
//        myLoc=mGoogleMap.addMarker(new MarkerOptions().position(latLng).title("Naivas Highway Mall").snippet("Click marker to shop with us!!"));
//        myLoc.showInfoWindow();
//        CameraPosition Geff2 = CameraPosition.builder().target(latLng).zoom(16).tilt(45).build();
//        mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Geff2));
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mGoogleMap = googleMap;
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        googleMap.setOnMarkerClickListener(this);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            if (ContextCompat.checkSelfPermission(this.getActivity(),
                    android.Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED)
            {
                //buildGoogleApiClient();
                mGoogleMap.setMyLocationEnabled(true);
            } else
            {
                //Request Location Permission to user
                checkPermission();
            }
        } else
        {
            //buildGoogleApiClient();
            mGoogleMap.setMyLocationEnabled(true);
        }



//
//        Marker marker=googleMap.addMarker(new MarkerOptions().position(new LatLng(-1.219222, 36.888219)).title("Thika Road Mall").snippet("Come shop with us!!"));
//         marker.showInfoWindow();
//        CameraPosition Geff = CameraPosition.builder().target(new LatLng(-1.219222, 36.888219)).zoom(16).bearing(0).tilt(45).build();
//        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Geff));

        marker2=googleMap.addMarker(new MarkerOptions().position(new LatLng(-1.287003, 36.880893)).title("Tuskys BuruBuru").snippet("Click marker to shop with us!!"));
        marker2.showInfoWindow();
        CameraPosition Geff2 = CameraPosition.builder().target(new LatLng(-1.287003, 36.880893)).zoom(16).tilt(45).build();
       googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Geff2));




    }

    @Override
    public boolean onMarkerClick(final Marker marker) {
        if (marker.equals(marker2)) {

            startActivity(new Intent(TabView.this.getActivity(),CartActivity.class));

        }
        return false;
    }





    //@Override

}

package com.impact.mymapproject;

import android.location.Address;
import android.graphics.Color;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    EditText search;
    Button go, normal, hybrid, satellite, terrain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        normal = (Button) findViewById(R.id.normalbtn);
        hybrid = (Button) findViewById(R.id.hybridbtn);

        satellite = (Button) findViewById(R.id.satellitebtn);
        terrain = (Button) findViewById(R.id.terrainbtn);


        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

            }
        });
        hybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

            }
        });
        satellite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);


            }
        });

        terrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);


            }
        });





        search = (EditText) findViewById(R.id.ed_search);
        go = (Button) findViewById(R.id.go_btn);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = search.getText().toString();

                List<Address> addressList = null;
                if (location != null || !location.equals("")) {
                    Geocoder geocoder = new Geocoder(MapsActivity.this);
                    try {
                        addressList = geocoder.getFromLocationName(location, 1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Address address = addressList.get(1);
                    LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                    String longi = String.valueOf(address.getLatitude());
                    String lat = String.valueOf(address.getLongitude());


                    mMap.addMarker(new MarkerOptions().position(latLng).title("LatLong-"+longi+","+lat));

                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));










                }


            }
        });



    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
//       LatLng kathmandu= new LatLng(27.7172453,85.3239605);
//        mMap.addMarker(new MarkerOptions().position(kathmandu).title("Kathmandu-27.7172453,85.3239605"));
//         LatLng bhaktapur = new LatLng(27.6710221,85.4298197);
//        mMap.addMarker(new MarkerOptions().position(bhaktapur).title("Bhaktapur-27.6710221,85.4298197"));
//         LatLng PATAN= new LatLng(27.6644011,85.3187914);
//        mMap.addMarker(new MarkerOptions().position(PATAN).title(" Patan-27.6644011,85.3187914"));
//          LatLng Thimi = new LatLng(27.6781812,85.3807886);
//        mMap.addMarker(new MarkerOptions().position(Thimi).title("Thimi-27.6781812,85.3807886"));

//        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
//            @Override
//            public void onMapClick(LatLng latLng) {
//                mMap.addMarker(new MarkerOptions().position(latLng));
//                mMap.addCircle(new CircleOptions().center(latLng).radius(10000).strokeColor(Color.BLUE).fillColor(Color.CYAN));
//            }
//        });

    }

}

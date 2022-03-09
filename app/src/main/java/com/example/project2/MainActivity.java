package com.example.project2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ImageButton androidImageButton;
    ImageButton androidImageButton2;
    ImageButton androidImageButton3;
    ImageButton androidImageButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);



        androidImageButton = (ImageButton) findViewById(R.id.mapButton);

        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "It works", Toast.LENGTH_LONG).show();
                openActivity();
            }
        });

        androidImageButton2 = (ImageButton) findViewById(R.id.roomButton);
        androidImageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "It works2", Toast.LENGTH_LONG).show();
                openActivity2();
            }
        });

        androidImageButton3 = (ImageButton) findViewById(R.id.eventButton);
        androidImageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "It works3", Toast.LENGTH_LONG).show();
                openActivity5();
            }
        });

        androidImageButton4 = (ImageButton) findViewById(R.id.settingButton);
        androidImageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "It works4", Toast.LENGTH_LONG).show();
                openActivity4();
            }
        });


    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        LatLng one = new LatLng(51.452505317648395, 5.483781791020252);
        LatLng two = new LatLng(51.4465266596796, 5.4991904032922445);

        LatLngBounds.Builder builder = new LatLngBounds.Builder();

        builder.include(one);
        builder.include(two);

        LatLngBounds bounds = builder.build();

        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;

        int padding = (int) (width * 0.01);

        mMap.setLatLngBoundsForCameraTarget(bounds);

        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding));

        mMap.setMinZoomPreference(mMap.getCameraPosition().zoom);

        //mMap.setMapType(mMap.MAP_TYPE_SATELLITE);

    }
    public void openActivity(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
    public void openActivity2(){
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
    public void openActivity4(){
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }
    public void openActivity5(){
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed(){
        Toast.makeText(this, "This will interfere with exiting from the app", Toast.LENGTH_LONG).show();
    }
}
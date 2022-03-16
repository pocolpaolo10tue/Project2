package com.example.project2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment mapsFragment = new MapsFragment();



        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.bottomNavigationView, mapsFragment)
                .commit();

        bottomNav.setOnItemSelectedListener(navListener);

    }

    private  NavigationBarView.OnItemSelectedListener navListener = new BottomNavigationView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            // By using switch we can easily get
            // the selected fragment
            // by using there id.
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.maps_Fragment:
                    selectedFragment = new MapsFragment();
                    break;
                case R.id.book_Fragment:
                    selectedFragment = new BookFragment();
                    break;
                case R.id.event_Fragment:
                    selectedFragment = new EventFragment();
                    break;
                case R.id.settings_Fragment:
                    selectedFragment = new SettingsFragment();
                    break;
            }
            //replace fragment
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.bottomNavigationView, selectedFragment)
                    .commit();
            return true;
        }
    };

    @Override
    public void onBackPressed(){
        Toast.makeText(this, "This will interfere with exiting from the app", Toast.LENGTH_LONG).show();
    }
}
package com.example.project2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_login);
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
//        mAuth = FirebaseAuth.getInstance();
//
//        Fragment mapsFragment = new MapsFragment();
//
//
//
//        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
//
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction()
//                .add(R.id.bottomNavigationView, mapsFragment)
//                .commit();
//                .setOnItemSelectedListener(navListener);

    }

    private final BottomNavigationView.OnItemSelectedListener navListener = item -> {
        // By using switch we can easily get
        // the selected fragment
        // by using there id.
        Fragment selectedFragment = new SettingsFragment();
            if (item.getItemId() == R.id.maps_Fragment) {
                selectedFragment = new MapsFragment();
            }
            else if (item.getItemId() == R.id.book_Fragment) {
                selectedFragment = new BookFragment();
            }
            else if (item.getItemId() == R.id.event_Fragment) {
                selectedFragment = new EventFragment();
            }
            else if (item.getItemId() == R.id.settings_Fragment) {
                selectedFragment = new SettingsFragment();
            }
            else if (item.getItemId() == R.id.login_Fragment) {
                selectedFragment = new SettingsFragment();
            }
        //replace fragment
        assert selectedFragment != null;
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.bottomNavigationView, selectedFragment)
                .commit();
        return true;
    };

    @Override
    public void onBackPressed(){
        Toast.makeText(this, "This will interfere with exiting from the app", Toast.LENGTH_LONG).show();
    }
}
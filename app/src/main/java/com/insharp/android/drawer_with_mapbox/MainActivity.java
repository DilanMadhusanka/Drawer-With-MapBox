package com.insharp.android.drawer_with_mapbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new FirstFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            /* By using switch we can easily get the selected fragment by using there id. */
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.firstFragment:
                    selectedFragment = new FirstFragment();
                    break;
                case R.id.secondFragment:
                    selectedFragment = new SecondFragment();
                    break;
                case R.id.thirdFragment:
                    selectedFragment = new ThirdFragment();
                    break;
                default:
                    selectedFragment = null;
                    break;
            }

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment, selectedFragment)
                    .commit();
            return true;
        }
    };
}
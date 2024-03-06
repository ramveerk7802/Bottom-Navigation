package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.idBottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id==R.id.idHomeNav){
                    loadFrag(new HomeFragment(),true);
                } else if (id==R.id.idSearchNav) {
                    loadFrag(new SearchFragment(),false);
                } else if (id==R.id.idCreateNav) {
                    loadFrag(new CreateFragment(),false);
                } else if (id==R.id.idSettingNav) {
                    loadFrag(new SettingFragment(),false);
                }
                else
                    loadFrag(new ProfileFragment(),false);
                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.idHomeNav);

    }
    public void loadFrag(Fragment fragment,boolean flage){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flage)
            ft.add(R.id.idFrameLayout,fragment);
        else
            ft.replace(R.id.idFrameLayout,fragment);
        ft.commit();
    }
}
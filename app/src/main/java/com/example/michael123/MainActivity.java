package com.example.michael123;

/*
    10118008
    Michael Nagaku Milenn Salim
    IF1
 */


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.michael123.fragment.*;

import com.example.michael123.model.Gallery;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity{

    public static Context contextOfApplication;
    public static Context getContextOfApplication()
    {
        return contextOfApplication;
    }

    private List<Gallery> gallery = new ArrayList<>();



    BottomNavigationView navigation;
    FrameLayout frame;
    Fragment active;

    @Override
    protected void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);
        setTheme(R.style.Michael);
        setContentView(R.layout.activity_main);

        contextOfApplication = getApplicationContext();

        frame = findViewById(R.id.frame);
        navigation = findViewById(R.id.bottomNavigationView);
        final Fragment fragment1 = new FragmentHome();
        final Fragment fragment2 = new FragmentDaily();
        final Fragment fragment3 = new FragmentGallery(this.gallery);
        final Fragment fragment4 = new FragmentMusic();
        final Fragment fragment5 = new FragmentProfile();
        final FragmentManager fm = getSupportFragmentManager();
        active = fragment1;
        fm.beginTransaction().add(R.id.frame, fragment5, "5").hide(fragment5).commit();
        fm.beginTransaction().add(R.id.frame, fragment4, "4").hide(fragment4).commit();
        fm.beginTransaction().add(R.id.frame, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.frame, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.frame, fragment1, "1").commit();

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_1:
                        Log.d("menu", "menu1");
                        fm.beginTransaction().hide(active).show(fragment1).commit();
                        active = fragment1;
                        return true;
                    case R.id.menu_2:
                        fm.beginTransaction().hide(active).show(fragment2).commit();
                        active = fragment2;
                        return true;
                    case R.id.menu_3:
                        fm.beginTransaction().hide(active).show(fragment3).commit();
                        active = fragment3;
                        return true;
                    case R.id.menu_4:
                        fm.beginTransaction().hide(active).show(fragment4).commit();
                        active = fragment4;
                        return true;
                    case R.id.menu_5:
                        fm.beginTransaction().hide(active).show(fragment5).commit();
                        active = fragment5;
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }




}
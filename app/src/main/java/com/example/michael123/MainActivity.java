package com.example.michael123;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.michael123.fragment.*;

import com.example.michael123.model.Gallery;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private List<Gallery> gallery = new ArrayList<>();

    BottomNavigationView navigation;
    FrameLayout frame;
    Fragment active;

    @Override
    protected void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);
        setTheme(R.style.Michael);
        setContentView(R.layout.activity_main);

        frame = findViewById(R.id.frame);
        navigation = findViewById(R.id.bottomNavigationView);
        final Fragment fragment1 = new FragmentHome();
        final Fragment fragment2 = new FragmentDaily();
        //populate();
        final Fragment fragment3 = new FragmentGallery(this.gallery);
        final FragmentManager fm = getSupportFragmentManager();
        active = fragment1;
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
                        active = fragment2;
                        return true;
                }
                return false;
            }
        });
    }




}
package com.example.michael123;

import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class TourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        // viewPager.setAdapter(new CustomPagerAdapter(this));
    }
}
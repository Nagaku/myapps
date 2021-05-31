package com.example.michael123;

import android.content.Intent;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.michael123.adapter.CustomPagerAdapter;

public class TourActivity extends AppCompatActivity {

    private Button btn;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPagerAdapter(this));
    }

    public void testo(android.view.View view) {
        Intent i = new Intent(TourActivity.this, MainActivity.class);
        startActivity(i);
        finish();

    }
}
package com.example.michael123;

/*
    10118008
    Michael Nagaku Milenn Salim
    IF1
 */


import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, TourActivity.class);
                startActivity(i);
                finish();
            }
        }, 2000);
    }
}

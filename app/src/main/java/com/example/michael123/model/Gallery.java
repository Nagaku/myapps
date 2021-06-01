package com.example.michael123.model;

import android.graphics.Bitmap;

public class Gallery {

    private Bitmap picture;


    public Gallery() {
    }

    public Gallery(Bitmap picture) {
        this.picture = picture;
    }

    public Bitmap getPicture() {
        return picture;
    }

    public void setPicture(Bitmap picture) {
        this.picture = picture;
    }

}

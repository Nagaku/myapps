package com.example.michael123.model;

/*
    10118008
    Michael Nagaku Milenn Salim
    IF1
 */


import android.graphics.Bitmap;

public class Friend {
    private Bitmap photo;
    private String nama;

    public Friend() {
    }

    public Friend(Bitmap photo, String nama) {
        this.photo = photo;
        this.nama = nama;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}

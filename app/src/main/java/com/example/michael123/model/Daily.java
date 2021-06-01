package com.example.michael123.model;

import android.graphics.Bitmap;

import org.w3c.dom.Text;

public class Daily {
    private Bitmap photo;
    private String title;
    private String body;

    public Daily() {
    }

    public Daily(Bitmap photo, String title, String body) {
        this.photo = photo;
        this.title = title;
        this.body = body;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

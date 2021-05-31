package com.example.michael123;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public interface Converter {
    public Bitmap drawableToBitmap (Drawable drawable);
}

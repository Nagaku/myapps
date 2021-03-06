package com.example.michael123.fragment;

/*
    10118008
    Michael Nagaku Milenn Salim
    IF1
 */


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.michael123.Converter;
import com.example.michael123.R;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import com.example.michael123.adapter.GalleryDataAdapter;
import com.example.michael123.model.Gallery;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentGallery#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentGallery extends Fragment implements Converter {

    private List<Gallery> gallery = new ArrayList<>();

    private RecyclerView recyclerView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentGallery() {
        // Required empty public constructor
    }


    public FragmentGallery(List<Gallery> gallery) {
        this.gallery = gallery;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentGallery.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentGallery newInstance(String param1, String param2) {
        FragmentGallery fragment = new FragmentGallery();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        recyclerView = view.findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 3));
        populate();
        recyclerView.setAdapter(new GalleryDataAdapter(this.gallery));
        return view;
    }

    public Bitmap drawableToBitmap (Drawable drawable) {

        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable)drawable).getBitmap();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    public void populate() {
        this.gallery.add((new Gallery(drawableToBitmap(getResources().getDrawable(R.drawable.g1)))));
        this.gallery.add((new Gallery(drawableToBitmap(getResources().getDrawable(R.drawable.g2)))));
        this.gallery.add((new Gallery(drawableToBitmap(getResources().getDrawable(R.drawable.g3)))));
        this.gallery.add((new Gallery(drawableToBitmap(getResources().getDrawable(R.drawable.g4)))));
        this.gallery.add((new Gallery(drawableToBitmap(getResources().getDrawable(R.drawable.g5)))));
        this.gallery.add((new Gallery(drawableToBitmap(getResources().getDrawable(R.drawable.g6)))));
        this.gallery.add((new Gallery(drawableToBitmap(getResources().getDrawable(R.drawable.g7)))));
        this.gallery.add((new Gallery(drawableToBitmap(getResources().getDrawable(R.drawable.g8)))));
        this.gallery.add((new Gallery(drawableToBitmap(getResources().getDrawable(R.drawable.g9)))));

    }



}
package com.example.michael123.fragment;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.michael123.Converter;
import com.example.michael123.R;
import com.example.michael123.adapter.DailyDataAdapter;
import com.example.michael123.adapter.FriendDataAdapter;
import com.example.michael123.model.Daily;
import com.example.michael123.model.Friend;
import com.example.michael123.model.Friend;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentDaily#newInstance} factory method to
 * create an instance of this com.example.michael123.fragment.
 */
public class FragmentDaily extends Fragment implements Converter {

    // TODO: Rename parameter arguments, choose names that match
    // the com.example.michael123.fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    List<Friend> fs = new ArrayList<Friend>();
    List<Daily> ds = new ArrayList<Daily>();
    RecyclerView re;
    RecyclerView red;
    FloatingActionButton fab;

    public FragmentDaily() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this com.example.michael123.fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of com.example.michael123.fragment FragmentDaily.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentDaily newInstance(String param1, String param2) {
        FragmentDaily fragment = new FragmentDaily();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this com.example.michael123.fragment
        View view = inflater.inflate(R.layout.fragment_daily, container, false);
        re = view.findViewById(R.id.reFriend);
        re.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
        populate();
        re.setAdapter(new FriendDataAdapter(fs));

        red = view.findViewById(R.id.reActivity);
        red.setLayoutManager(new LinearLayoutManager(view.getContext()));
        populate2();
        DailyDataAdapter dda = new DailyDataAdapter(ds);
        red.setAdapter(dda);

        fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatDialog form = new AppCompatDialog(view.getContext());
                form.setContentView(R.layout.form_daily);
                if(!form.isShowing()) {
                    TextView tv = form.findViewById(R.id.frmBtn);
                    tv.setText("Save");
                    tv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Daily nd = new Daily();
                            TextView title = form.findViewById(R.id.frmTitle);
                            TextView desc = form.findViewById(R.id.frmDesc);
                            nd.setTitle(title.getText().toString());
                            nd.setBody(desc.getText().toString());
                            ds.add(nd);
                            dda.notifyDataSetChanged();
                            form.dismiss();
                        }
                    });
                    form.show();
                }
            }
        });


        return view;
    }


    public void populate() {
        Friend g1 = new Friend();
        Drawable d = getResources().getDrawable(R.drawable.ic_launcher_background);
        Bitmap bitmap = drawableToBitmap(d);
        g1.setPhoto(bitmap);
        g1.setNama("Rychoo Rantung");
        this.fs.add(g1);

        Friend g2 = new Friend();
        g2.setPhoto(bitmap);
        g2.setNama("Fiqri Akbhar Pratama");
        this.fs.add(g2);

        Friend g3 = new Friend();
        g3.setPhoto(bitmap);
        g3.setNama("Zaenal Anzari");
        this.fs.add(g3);

        Friend g4 = new Friend();
        g4.setPhoto(bitmap);
        g4.setNama("Adi");
        this.fs.add(g4);

    }

    public void populate2() {
        Daily g1 = new Daily();
        Drawable d = getResources().getDrawable(R.drawable.ic_launcher_background);
        Bitmap bitmap = drawableToBitmap(d);
        g1.setPhoto(bitmap);
        g1.setTitle("Jalan Pagi");
        this.ds.add(g1);

        Daily g2 = new Daily();
        g2.setPhoto(bitmap);
        g2.setTitle("Makan Siang");
        this.ds.add(g2);

        Daily g3 = new Daily();
        g3.setPhoto(bitmap);
        g3.setTitle("Main Game");
        this.ds.add(g3);

        Daily g4 = new Daily();
        g4.setPhoto(bitmap);
        g4.setTitle("Nonton Movie");
        this.ds.add(g4);

    }

}
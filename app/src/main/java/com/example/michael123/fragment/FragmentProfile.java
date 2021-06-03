package com.example.michael123.fragment;

/*
    10118008
    Michael Nagaku Milenn Salim
    IF1
 */


import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.michael123.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentProfile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentProfile extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    AppCompatDialog version;

    public FragmentProfile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentProfile.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentProfile newInstance(String param1, String param2) {
        FragmentProfile fragment = new FragmentProfile();
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

    public void showVersion(View view) {
        version = new AppCompatDialog(view.getContext());
        version.setContentView(R.layout.version_pop);
        version.setTitle("About this application");

        if (!version.isShowing())
            version.show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        Button button = (Button) view.findViewById(R.id.callme);
        Button btnm = (Button) view.findViewById(R.id.mailme);
        Button btni = (Button) view.findViewById(R.id.followme);
        Button btnf = (Button) view.findViewById(R.id.findme);
        Button btnv = (Button) view.findViewById(R.id.version);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                String phone = "081338141194";
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));

                startActivity(callIntent);
            }
        });

        btnm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                try{
                    Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "michael.10118008@mahasiswa.unikom.ac.id"));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Android");
                    startActivity(intent);
                }catch(ActivityNotFoundException e){
                    //TODO smth
                }
            }
        });

        btni.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/mimelnagaku/")));
            }
        });


        btnf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/W75p9s7XyBRt3bYc6")));
            }
        });


        btnv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                showVersion(arg0);
            }
        });

        return view;
    }

}
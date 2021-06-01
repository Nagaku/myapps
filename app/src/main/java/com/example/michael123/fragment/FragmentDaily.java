package com.example.michael123.fragment;

import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.michael123.Converter;
import com.example.michael123.MainActivity;
import com.example.michael123.R;
import com.example.michael123.adapter.DailyDataAdapter;
import com.example.michael123.adapter.FriendDataAdapter;
import com.example.michael123.model.Daily;
import com.example.michael123.model.Friend;
import com.example.michael123.model.Friend;
import com.example.michael123.presenter.PresenterImage;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.widget.Toast;

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
    private static final int MY_REQUEST = 617;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    List<Friend> fs = new ArrayList<Friend>();
    List<Daily> ds = new ArrayList<Daily>();
    RecyclerView re;
    RecyclerView red;
    FloatingActionButton fab;
    Bitmap foto;
    ImageView pp;
    TextView title;
    TextView desc;
    Button tv;

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
        DailyDataAdapter dda = new DailyDataAdapter(ds, getActivity());
        red.setAdapter(dda);

        fab = view.findViewById(R.id.fab);
        AppCompatDialog form = new AppCompatDialog(view.getContext());
        form.setContentView(R.layout.form_daily);
        title = form.findViewById(R.id.frmTitle);
        desc = form.findViewById(R.id.frmDesc);
        pp = form.findViewById(R.id.frmProfile);
        tv = form.findViewById(R.id.frmBtn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!form.isShowing()) {
                    pp.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setImage();
                        }
                    });
                    tv.setText("Save");
                    tv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Daily nd = new Daily();
                            nd.setPhoto(drawableToBitmap(pp.getDrawable()));
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


    public void setImage(){
        Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        i.putExtra("crop", "true");
        i.putExtra("aspectX", 100);
        i.putExtra("aspectY", 100);
        i.putExtra("outputX", 150);
        i.putExtra("outputY", 150);

        try {

            i.putExtra("return-data", true);
            startActivityForResult(
                    Intent.createChooser(i, "data1"), 0);
            Log.d("ola", "we cool");
        }catch (ActivityNotFoundException ex){
            ex.printStackTrace();
            Log.d("ola", ex.getMessage());
        }


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle = data.getExtras();

        if(requestCode==0 && resultCode == Activity.RESULT_OK){
            try {
                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };
                Cursor cursor = getActivity().getContentResolver().query(selectedImage, filePathColumn, null, null, null);

                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                BitmapFactory.Options options;
                if (ContextCompat.checkSelfPermission(
                        getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) ==
                        PackageManager.PERMISSION_GRANTED) {
                    try {
                        foto = (Bitmap) (BitmapFactory.decodeFile(picturePath));
                        Log.d("image", "berhasil");
                    } catch (OutOfMemoryError e) {
                        Log.d("image", e.getMessage());
                        try {
                            options = new BitmapFactory.Options();
                            options.inSampleSize = 2;
                            foto = BitmapFactory.decodeFile(picturePath, options);
                            Log.d("image", "berhasil 2");
                        } catch (Exception excepetion) {
                            Log.e("error image", excepetion.getMessage());
                        }
                    }
                } else {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[] { Manifest.permission.READ_EXTERNAL_STORAGE },
                            MY_REQUEST);
                    Toast.makeText(getContext(),"Silahkan coba lagi", Toast.LENGTH_SHORT).show();
                }

                cursor.close();
                pp.setImageBitmap(foto);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    public void populate() {
        this.fs.add(new Friend(drawableToBitmap(getResources().getDrawable(R.drawable.rico)), "Rychoo Rantung"));
        this.fs.add(new Friend(drawableToBitmap(getResources().getDrawable(R.drawable.fiqri)), "Fiqri Akbar"));
        this.fs.add(new Friend(drawableToBitmap(getResources().getDrawable(R.drawable.zaenal)), "Zaenal Anzarry"));
        this.fs.add(new Friend(drawableToBitmap(getResources().getDrawable(R.drawable.adi)), "Adi Chandra"));
    }

    public void populate2() {
        this.ds.add(new Daily(drawableToBitmap(getResources().getDrawable(R.drawable.badminton)), "Jalan Pagi", "jalan pagi-pagi mantab"));
        this.ds.add(new Daily(drawableToBitmap(getResources().getDrawable(R.drawable.badminton)), "Makan Pagi", "makan pagi-pagi mantab"));
        this.ds.add(new Daily(drawableToBitmap(getResources().getDrawable(R.drawable.badminton)), "Tidur Pagi", "tidur pagi-pagi mantab"));
    }

}
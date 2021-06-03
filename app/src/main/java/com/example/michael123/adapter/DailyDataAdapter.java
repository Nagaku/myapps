package com.example.michael123.adapter;

/*
    10118008
    Michael Nagaku Milenn Salim
    IF1
 */

import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.RecyclerView;

import com.example.michael123.R;
import com.example.michael123.model.Daily;

import java.util.ArrayList;
import java.util.List;

public class DailyDataAdapter extends RecyclerView.Adapter<DailyDataAdapter.ViewHolder> {

    List<Daily> dailies = new ArrayList<Daily>();
    Activity activity;

    public DailyDataAdapter(List<Daily> dailies, Activity activity) {
        this.activity = activity;
        this.dailies = dailies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.daily, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Daily daily = dailies.get(position);
        holder.img.setImageBitmap(daily.getPhoto());
        holder.title.setText(daily.getTitle());
    }

    @Override
    public int getItemCount() {
        return dailies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView img;
        private TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.photoDaily);
            title = itemView.findViewById(R.id.titleDaily);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            AppCompatDialog form = new AppCompatDialog(v.getContext());
            form.setContentView(R.layout.form_daily);
            Daily nd = new Daily();
            nd = dailies.get(getAdapterPosition());
            ImageView img = form.findViewById(R.id.frmProfile);
            TextView title = form.findViewById(R.id.frmTitle);
            TextView desc = form.findViewById(R.id.frmDesc);
            img.setImageBitmap(nd.getPhoto());
            title.setText(nd.getTitle());
            desc.setText(nd.getBody());
            if(!form.isShowing()) {
                TextView tv = form.findViewById(R.id.frmBtn);
                tv.setText("Edit");
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Daily nd = new Daily();
                        nd = dailies.get(getAdapterPosition());
                        nd.setTitle(title.getText().toString());
                        nd.setBody(desc.getText().toString());
                        notifyDataSetChanged();
                        form.dismiss();
                    }
                });
                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
                form.show();
            }
        }
    }



}

package com.example.michael123.adapter;

import android.graphics.BitmapFactory;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.michael123.R;
import com.example.michael123.model.Gallery;

import java.util.List;
import java.util.zip.Inflater;

public class GalleryDataAdapter extends RecyclerView.Adapter<GalleryDataAdapter.ViewHolder> {

    private List<Gallery> gallery;

    public GalleryDataAdapter(List<Gallery> gallery) {
        this.gallery = gallery;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =  LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.gallery_gambar, parent, false);
        return(new ViewHolder(view));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Gallery gallery = this.gallery.get(position);
        holder.picture.setImageBitmap(gallery.getPicture());
    }

    @Override
    public int getItemCount() {
            return gallery.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            private ImageView picture;

            public ViewHolder(View view) {
                super(view);
                view.setOnClickListener(this);
                picture = view.findViewById(R.id.picture);

            }

            @Override
            public void onClick(View v) {

            }
        }

}

package com.example.michael123.adapter;

/*
    10118008
    Michael Nagaku Milenn Salim
    IF1
 */


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.michael123.R;
import com.example.michael123.model.Friend;

import org.w3c.dom.Text;

import java.util.List;

public class FriendDataAdapter extends RecyclerView.Adapter<FriendDataAdapter.ViewHolder> {

    private List<Friend> fs;

    public FriendDataAdapter(List<Friend> fs) {
        this.fs = fs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.friend, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Friend f = this.fs.get(position);
        holder.pp.setImageBitmap(f.getPhoto());
        holder.nama.setText(f.getNama());
    }

    @Override
    public int getItemCount() {
        return fs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView pp;
        private TextView nama;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pp = itemView.findViewById(R.id.pp);
            nama = itemView.findViewById(R.id.nama);
        }
    }
}

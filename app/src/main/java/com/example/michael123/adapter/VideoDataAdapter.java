package com.example.michael123.adapter;

/*
    10118008
    Michael Nagaku Milenn Salim
    IF1
 */


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.michael123.R;
import com.example.michael123.model.Video;

import java.util.List;
import java.util.zip.Inflater;

public class VideoDataAdapter extends RecyclerView.Adapter<VideoDataAdapter.ViewHolder> {

    List<Video> videos;

    public VideoDataAdapter(List<Video> videos) {
        this.videos = videos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.video, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.vid.loadData(videos.get(position).getVid(), "text/html", "utf-8");
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private WebView vid;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            vid = itemView.findViewById(R.id.video);
            vid.getSettings().setJavaScriptEnabled(true);
            vid.setWebChromeClient(new WebChromeClient());

        }
    }
}

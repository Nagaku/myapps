package com.example.michael123.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.michael123.R;
import com.example.michael123.model.Daily;

import java.util.ArrayList;
import java.util.List;

public class DailyDataAdapter extends RecyclerView.Adapter<DailyDataAdapter.ViewHolder> {

    List<Daily> dailies = new ArrayList<Daily>();

    public DailyDataAdapter(List<Daily> dailies) {
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
            TextView title = form.findViewById(R.id.frmTitle);
            TextView desc = form.findViewById(R.id.frmDesc);
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
                form.show();
            }
        }
    }
}

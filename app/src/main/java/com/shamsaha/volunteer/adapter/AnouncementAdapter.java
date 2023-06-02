package com.shamsaha.volunteer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shamsaha.R;


public class AnouncementAdapter extends RecyclerView.Adapter<AnouncementViewHolder> {

    private Context context;

    public AnouncementAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public AnouncementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.anouncement_holder_design,parent,false);
        return new AnouncementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnouncementViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 40;
    }
}

class AnouncementViewHolder extends RecyclerView.ViewHolder{

    public AnouncementViewHolder(@NonNull View itemView) {
        super(itemView);

    }
}

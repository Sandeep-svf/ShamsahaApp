package com.shamsaha.victim.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shamsaha.R;

public class EventMediaPhotoAdapter extends RecyclerView.Adapter<PhotoViewHolder> {

    private Context context;

    public EventMediaPhotoAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.photo_view_holder_design,parent,false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
class PhotoViewHolder extends  RecyclerView.ViewHolder{

    public PhotoViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
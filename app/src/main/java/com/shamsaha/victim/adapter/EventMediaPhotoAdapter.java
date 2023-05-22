package com.shamsaha.victim.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.shamsaha.R;
import com.shamsaha.victim.model.res.MediaPhotoRes;

import java.util.ArrayList;
import java.util.List;

public class EventMediaPhotoAdapter extends RecyclerView.Adapter<PhotoViewHolder> {

    private Context context;
    private List<MediaPhotoRes> mediaPhotoResList = new ArrayList<>();

    public EventMediaPhotoAdapter(Context context, List<MediaPhotoRes> mediaPhotoResList) {
        this.context = context;
        this.mediaPhotoResList = mediaPhotoResList;
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

        Glide.with(context)
                .load(mediaPhotoResList.get(position).getMediaImage())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mediaPhotoResList.size();
    }
}
class PhotoViewHolder extends  RecyclerView.ViewHolder{

    AppCompatImageView image;
    public PhotoViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.image);
    }
}
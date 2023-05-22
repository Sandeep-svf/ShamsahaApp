package com.shamsaha.victim.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import com.shamsaha.R;
import com.shamsaha.victim.model.res.MediaArticleRes;

import java.util.ArrayList;
import java.util.List;

public class EventMediaArticleAdapter extends RecyclerView.Adapter<ArticleViewHolder> {

    private Context context;
    private List<MediaArticleRes> mediaArticleResList = new ArrayList<>();

    public EventMediaArticleAdapter(Context context, List<MediaArticleRes> mediaArticleResList) {
        this.context = context;
        this.mediaArticleResList = mediaArticleResList;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.article_view_holder,parent,false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {

        holder.content.setText(mediaArticleResList.get(position).getContent());
        holder.dateTime.setText(mediaArticleResList.get(position).getDate()+"   "+mediaArticleResList.get(position).getTime());
        Glide.with(context)
                .load(mediaArticleResList.get(position).getImage())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.image);



    }

    @Override
    public int getItemCount() {
        return mediaArticleResList.size();
    }
}
class ArticleViewHolder extends RecyclerView.ViewHolder{

    ShapeableImageView image;
    TextView content, dateTime;

    public ArticleViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.image);
        content = itemView.findViewById(R.id.textView22);
        dateTime = itemView.findViewById(R.id.textView23);
    }
}
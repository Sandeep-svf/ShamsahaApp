package com.shamsaha.victim.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.shamsaha.R;
import com.shamsaha.retrofit.API_Client;
import com.shamsaha.victim.model.res.ResourcesCaregoryRes;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ResourcesPerCountryAdapter extends RecyclerView.Adapter<PerCountryViewHolder> {

    private Context context;
    List<ResourcesCaregoryRes> resourcesCaregoryResList = new ArrayList<>();

    public ResourcesPerCountryAdapter(Context context, List<ResourcesCaregoryRes> resourcesCaregoryResList) {
        this.context = context;
        this.resourcesCaregoryResList = resourcesCaregoryResList;
    }

    @NonNull
    @Override
    public PerCountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.per_country_view_holder,parent,false);
        return new PerCountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PerCountryViewHolder holder, int position) {

        holder.cat_name.setText( resourcesCaregoryResList.get(position).getCategoryName());
        Glide.with(context).load(API_Client.BASE_IMAGE_URL+resourcesCaregoryResList.get(position).getCategoryIcon())
                .placeholder(R.drawable.logo)
                .into(holder.cat_icon);

        holder.item_per_country_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }

    @Override
    public int getItemCount() {
        return resourcesCaregoryResList.size();
    }
}
class PerCountryViewHolder extends RecyclerView.ViewHolder{

    CardView item_per_country_layout;
    AppCompatTextView cat_name;
    CircleImageView cat_icon;
    public PerCountryViewHolder(@NonNull View itemView) {
        super(itemView);
        item_per_country_layout = itemView.findViewById(R.id.item_per_country_layout);
        cat_name = itemView.findViewById(R.id.cat_name);
        cat_icon = itemView.findViewById(R.id.cat_icon);
    }
}
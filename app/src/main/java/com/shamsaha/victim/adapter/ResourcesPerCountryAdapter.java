package com.shamsaha.victim.adapter;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
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
        Glide.with(context).load(resourcesCaregoryResList.get(position).getCategoryIcon())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.cat_icon);

        Log.e("test_sam_resources",resourcesCaregoryResList.get(position).getCategoryIcon());

        holder.item_per_country_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // holder.cat_icon.setColorFilter(ContextCompat.getColor(context, R.color.pick_them), android.graphics.PorterDuff.Mode.MULTIPLY);
              //  holder.cat_icon3.setBackgroundResource(R.color.white);

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
    AppCompatImageView cat_icon;
    CircleImageView cat_icon3;
    public PerCountryViewHolder(@NonNull View itemView) {
        super(itemView);
        item_per_country_layout = itemView.findViewById(R.id.item_per_country_layout);
        cat_name = itemView.findViewById(R.id.cat_name);
        cat_icon = itemView.findViewById(R.id.cat_icon);
        cat_icon3 = itemView.findViewById(R.id.cat_icon3);
    }
}
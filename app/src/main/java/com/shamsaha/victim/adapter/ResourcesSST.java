package com.shamsaha.victim.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.shamsaha.R;

public class ResourcesSST extends RecyclerView.Adapter<SSTViewHolder> {

    private Context context;

    public ResourcesSST(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public SSTViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sst_view_holder,parent,false);
        return new SSTViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SSTViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 30;
    }
}
class SSTViewHolder extends RecyclerView.ViewHolder{

    CardView item_view_card_sst;
    public SSTViewHolder(@NonNull View itemView) {
        super(itemView);
        item_view_card_sst = itemView.findViewById(R.id.item_view_card_sst);
    }
}
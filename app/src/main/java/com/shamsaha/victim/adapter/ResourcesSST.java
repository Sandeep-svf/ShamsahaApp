package com.shamsaha.victim.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.shamsaha.R;
import com.shamsaha.util.UtilFunction;
import com.shamsaha.util.WebviewActivity;
import com.shamsaha.victim.model.SSTDataEn;
import com.shamsaha.victim.model.res.SSTRes;

import java.util.ArrayList;
import java.util.List;

public class ResourcesSST extends RecyclerView.Adapter<SSTViewHolder> {

    private Context context;
    List<SSTDataEn> sstResList = new ArrayList<>();

    public ResourcesSST(Context context, List<SSTDataEn> sstResList) {
        this.context = context;
        this.sstResList = sstResList;
    }

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
    public void onBindViewHolder(@NonNull SSTViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.textView18.setText(sstResList.get(position).getName());
        holder.item_view_card_sst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = sstResList.get(position).getPath();
                Intent intent = new Intent(context, WebviewActivity.class);
                intent.putExtra("key", UtilFunction.sstKey);
                intent.putExtra("url", url);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sstResList.size();
    }
}
class SSTViewHolder extends RecyclerView.ViewHolder{

    CardView item_view_card_sst;
    TextView textView18;
    public SSTViewHolder(@NonNull View itemView) {
        super(itemView);
        item_view_card_sst = itemView.findViewById(R.id.item_view_card_sst);
        textView18 = itemView.findViewById(R.id.textView18);
    }
}
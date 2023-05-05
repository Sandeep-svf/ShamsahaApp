package com.shamsaha.victim.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shamsaha.R;

public class AboutAdvisoryBoardAdapter extends RecyclerView.Adapter<AdvisoryBoardViewHolder> {

    private Context context;

    public AboutAdvisoryBoardAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public AdvisoryBoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.advisory_board_holder_design,parent,false);
        return new AdvisoryBoardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdvisoryBoardViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 45;
    }
}
class AdvisoryBoardViewHolder extends RecyclerView.ViewHolder{

    public AdvisoryBoardViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
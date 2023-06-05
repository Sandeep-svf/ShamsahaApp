package com.shamsaha.volunteer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.shamsaha.R;

public class IncomingChatAdapter extends RecyclerView.Adapter<IncomingChatViewHolder> {


    @NonNull
    @Override
    public IncomingChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.incoming_chat_holder_design,parent,false);
        return new IncomingChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IncomingChatViewHolder holder, int position) {



    }

    @Override
    public int getItemCount() {
        return 20;
    }
}


class IncomingChatViewHolder extends RecyclerView.ViewHolder{

    public IncomingChatViewHolder(@NonNull View itemView) {
        super(itemView);



    }
}
package com.shamsaha.victim.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.shamsaha.R;
import com.shamsaha.victim.model.res.EventVolunteerRes;

import java.util.ArrayList;
import java.util.List;

public class EventVounteerAdapter extends RecyclerView.Adapter<EventVolunteerViewHolder> {

    private Context context;
    private List<EventVolunteerRes> eventVolunteerResList = new ArrayList<>();

    public EventVounteerAdapter(Context context, List<EventVolunteerRes> eventVolunteerResList) {
        this.context = context;
        this.eventVolunteerResList = eventVolunteerResList;
    }

    @NonNull
    @Override
    public EventVolunteerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.volunteer_view_holder_design,parent,false);
        return new EventVolunteerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventVolunteerViewHolder holder, int position) {

        holder.heading.setText(eventVolunteerResList.get(position).getEventName());
        holder.date.setText(eventVolunteerResList.get(position).getEventDate());
        holder.time.setText(eventVolunteerResList.get(position).getEventTime());
        holder.address.setText(eventVolunteerResList.get(position).getEventAddress());
        Glide.with(context)
                .load(eventVolunteerResList.get(position).getEventImage())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return eventVolunteerResList.size();
    }
}

class EventVolunteerViewHolder extends RecyclerView.ViewHolder{

    AppCompatImageView image;
    AppCompatTextView date;
    TextView heading,time,address;

    public EventVolunteerViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.image);
        date = itemView.findViewById(R.id.date);
        heading = itemView.findViewById(R.id.textView19);
        time = itemView.findViewById(R.id.textView20);
        address = itemView.findViewById(R.id.textView21);
    }
}
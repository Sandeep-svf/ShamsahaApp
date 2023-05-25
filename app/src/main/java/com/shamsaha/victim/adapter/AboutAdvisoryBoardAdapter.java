package com.shamsaha.victim.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import com.shamsaha.R;
import com.shamsaha.retrofit.API_Client;
import com.shamsaha.util.TopRoundedCornerDrawable;
import com.shamsaha.victim.model.res.AboutBoardMemberRes;

import java.util.ArrayList;
import java.util.List;

public class AboutAdvisoryBoardAdapter extends RecyclerView.Adapter<AdvisoryBoardViewHolder> {

    private Context context;
    List<AboutBoardMemberRes> aboutBoardMemberResList = new ArrayList<>();

    public AboutAdvisoryBoardAdapter(Context context, List<AboutBoardMemberRes> aboutBoardMemberResList) {
        this.context = context;
        this.aboutBoardMemberResList = aboutBoardMemberResList;
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



        Glide.with(context)
                .load(aboutBoardMemberResList.get(position).getImage())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.image_board_member);

        holder.name_board_member.setText(aboutBoardMemberResList.get(position).getBname());
        holder.designation_board_member.setText(aboutBoardMemberResList.get(position).getDesignation());


        holder.item_view_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // popup

            }
        });

    }

    @Override
    public int getItemCount() {
        return aboutBoardMemberResList.size();
    }


    private void alert_dialog_message() {

        AlertDialog dialogs;

        LayoutInflater inflater= LayoutInflater.from(context);
        View alertLayout = inflater.inflate(R.layout.about_details, null);
        final AppCompatImageView close_dialog = alertLayout.findViewById(R.id.close_dialog);


        final androidx.appcompat.app.AlertDialog.Builder alert = new AlertDialog.Builder(context);

        alert.setView(alertLayout);
        alert.setCancelable(false);

        dialogs = alert.create();
        dialogs.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogs.show();
        dialogs.setCanceledOnTouchOutside(true);


        close_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialogs.dismiss();
            }
        });
    }

}
class AdvisoryBoardViewHolder extends RecyclerView.ViewHolder{

    AppCompatImageView image_board_member;
    CardView item_view_about;
    AppCompatTextView name_board_member,designation_board_member;

    public AdvisoryBoardViewHolder(@NonNull View itemView) {
        super(itemView);
        item_view_about = itemView.findViewById(R.id.item_view_about);
        image_board_member = itemView.findViewById(R.id.image_board_member);
        name_board_member = itemView.findViewById(R.id.name_board_member);
        designation_board_member = itemView.findViewById(R.id.designation_board_member);
    }
}
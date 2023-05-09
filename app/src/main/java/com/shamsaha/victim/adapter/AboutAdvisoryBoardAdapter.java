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

        holder.item_view_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // popup
                alert_dialog_message();
            }
        });

    }

    @Override
    public int getItemCount() {
        return 45;
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

    CardView item_view_about;

    public AdvisoryBoardViewHolder(@NonNull View itemView) {
        super(itemView);
        item_view_about = itemView.findViewById(R.id.item_view_about);
    }
}
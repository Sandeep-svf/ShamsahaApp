package com.shamsaha.victim.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.shamsaha.R;

public class ResourcesPerCountryAdapter extends RecyclerView.Adapter<PerCountryViewHolder> {

    private Context context;

    public ResourcesPerCountryAdapter(Context context) {
        this.context = context;
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

        holder.item_per_country_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
class PerCountryViewHolder extends RecyclerView.ViewHolder{

    CardView item_per_country_layout;
    public PerCountryViewHolder(@NonNull View itemView) {
        super(itemView);
        item_per_country_layout = itemView.findViewById(R.id.item_per_country_layout);
    }
}
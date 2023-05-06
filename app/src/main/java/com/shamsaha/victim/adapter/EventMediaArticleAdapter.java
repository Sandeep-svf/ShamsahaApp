package com.shamsaha.victim.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.shamsaha.R;

public class EventMediaArticleAdapter extends RecyclerView.Adapter<ArticleViewHolder> {

    private Context context;

    public EventMediaArticleAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.article_view_holder,parent,false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
class ArticleViewHolder extends RecyclerView.ViewHolder{

    public ArticleViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
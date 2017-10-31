package com.example.android.library.ui.news;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.library.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsAdapterViewHolder> {

    List<String> news = new ArrayList<>();

    public NewsAdapter(List<String> news){
        this.news = news;
    }


    @Override
    public NewsAdapter.NewsAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.new_item, parent, false);
        return new NewsAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NewsAdapter.NewsAdapterViewHolder holder, int position) {
        position++;
        holder.title.setText("Заголовок " + position);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data = dateFormat.format(new Date());
        holder.date.setText(data);
        holder.shorts.setText("Краткое описание " + position);
//        holder.image.setImageResource(R.drawable.avd_hide_password_1);
       // holder.image.setImageResource(R.drawable.im);

    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class NewsAdapterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.shorts)
        TextView shorts;
        @BindView(R.id.data)
        TextView date;
        @BindView(R.id.image)
        ImageView image;

        public NewsAdapterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

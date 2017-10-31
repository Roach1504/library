package com.example.android.library.ui.chat;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.library.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatAdapterViewHolder>{
    List<String> messags = new ArrayList<>();
    public ChatAdapter(List<String> messags){
        this.messags = messags;
    }

    @Override
    public ChatAdapter.ChatAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView  = LayoutInflater.from(parent.getContext()).inflate(R.layout.messag_item_right, parent, false);;
        switch (viewType)
        {
            case 0:
                itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.messag_item_right, parent, false);
                break;
            case 1:
                itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item_left, parent, false);
                break;
        }
        return new ChatAdapterViewHolder(itemLayoutView);
    }

    int my = 0;
    @Override
    public int getItemViewType(int position) {

        if (position == my)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }

    @Override
    public void onBindViewHolder(ChatAdapter.ChatAdapterViewHolder holder, int position) {
        if(position%3==0){
            my = position;
        }
        if(my==position){
            holder.login.setText("Roach1504");
        }
        else{
            holder.login.setText("Собеседник " + (position++));
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data = dateFormat.format(new Date());
        holder.date.setText(data);
        holder.text.setText("Cобщение " + (position++));

    }

    @Override
    public int getItemCount() {
        return messags.size();
    }

    public class ChatAdapterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_messag)
        TextView text;
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.login)
        TextView login;

        public ChatAdapterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

package com.example.android.library.ui.chat;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.library.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SendFragment extends Fragment{
    @BindView(R.id.send_message)
    ImageView sendMessage;
    @BindView(R.id.text_message)
    TextView text;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_item, container, false);
        ButterKnife.bind(this, view);

        ChatFragment youFragment = new ChatFragment();
        android.app.FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()          // получаем экземпляр FragmentTransaction
                .replace(R.id.message_list, youFragment)
                .addToBackStack("myStack")
                .commit();

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}

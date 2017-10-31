package com.example.android.library.ui.chat;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.library.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SendFragment extends Fragment {
    @BindView(R.id.send_message)
    ImageView sendMessage;
    @BindView(R.id.text_message)
    TextView text;
    @BindView(R.id.message_list)
    RecyclerView mRecyclerView;
    @BindView(R.id.floatingActionButton)
    FloatingActionButton fab;
    @BindView(R.id.send_text)
    View sendText;
    @BindView(R.id.back)
    ImageView back;

    View nav;
    ChatAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_item, container, false);
        ButterKnife.bind(this, view);
        nav = getActivity().findViewById(R.id.navigation);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(adapter);
        List<String> mass = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mass.add("1");
        }
        Log.e("TEST", "start");
        adapter = new ChatAdapter(mass);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.getAdapter().notifyDataSetChanged();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendText.setVisibility(View.VISIBLE);
                fab.setVisibility(View.GONE);
                nav.setVisibility(View.GONE);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendText.setVisibility(View.INVISIBLE);
                fab.setVisibility(View.VISIBLE);
                nav.setVisibility(View.VISIBLE);
            }
        });
        return view;
    }
}

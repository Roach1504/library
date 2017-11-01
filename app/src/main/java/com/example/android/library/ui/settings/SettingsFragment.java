package com.example.android.library.ui.settings;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.library.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SettingsFragment extends Fragment {

    View nav;
    @BindView(R.id.editText)
    EditText mEditText;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.settings, container);
        ButterKnife.bind(this, view);
        nav = getActivity().findViewById(R.id.navigation);
        return super.onCreateView(inflater, container, savedInstanceState);
    }


}

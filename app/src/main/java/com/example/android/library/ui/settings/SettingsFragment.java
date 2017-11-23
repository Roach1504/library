package com.example.android.library.ui.settings;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.android.library.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SettingsFragment extends Fragment {

    View nav;
    @BindView(R.id.editText)
    EditText mEditText;

    SharedPreferences mSettings;
    @BindView(R.id.checkBox)
    CheckBox mCheckBox;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.settings, container, false);
        ButterKnife.bind(this, view);
        nav = getActivity().findViewById(R.id.navigation);
        mSettings = getActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        mCheckBox.setChecked(mSettings.getBoolean("Check",false));
        mEditText.setText(mSettings.getString("Nickname","Noname"));
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        mSettings.edit().putString("Nickname", mEditText.getText().toString()).apply();
        mSettings.edit().putBoolean("Check",(mCheckBox.isChecked())).apply();
    }

    @Override
    public void onStop() {
        super.onStop();
        mSettings.edit().putString("Nickname", mEditText.getText().toString()).apply();
        mSettings.edit().putBoolean("Check",(mCheckBox.isChecked())).apply();

    }


}

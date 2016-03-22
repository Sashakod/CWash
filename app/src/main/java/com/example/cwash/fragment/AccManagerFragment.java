package com.example.cwash.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cwash.R;

public class AccManagerFragment extends Fragment {
    private static final int LAYOUT = R.layout.fragment_acc_manager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(LAYOUT,null);
        return v;
    }
}

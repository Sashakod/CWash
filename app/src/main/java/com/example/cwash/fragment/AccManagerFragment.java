package com.example.cwash.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
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

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Управление аккаунтом");
        FloatingActionButton fab = (FloatingActionButton)getActivity().findViewById(R.id.fab);
        fab.hide();

        return v;
    }
}

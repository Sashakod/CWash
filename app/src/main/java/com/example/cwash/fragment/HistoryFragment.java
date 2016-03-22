package com.example.cwash.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cwash.R;
import com.example.cwash.adapter.CarListAdapter;
import com.example.cwash.dto.CarDTO;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends Fragment {
    private static final int LAYOUT = R.layout.fragment_history;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(LAYOUT,null);

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new CarListAdapter(creatMockCarListData()));
        return view;
    }


    private List<CarDTO> creatMockCarListData() {
        List<CarDTO> data = new ArrayList<>();
        data.add(new CarDTO("Машина 1"));
        data.add(new CarDTO("Машина 2"));
        data.add(new CarDTO("Машина 3"));
        data.add(new CarDTO("Машина 4"));
        data.add(new CarDTO("Машина 5"));
        data.add(new CarDTO("Машина 6"));
        data.add(new CarDTO("Машина 1"));
        data.add(new CarDTO("Машина 2"));
        data.add(new CarDTO("Машина 3"));
        data.add(new CarDTO("Машина 4"));
        data.add(new CarDTO("Машина 5"));
        data.add(new CarDTO("Машина 6"));
        data.add(new CarDTO("Машина 1"));
        data.add(new CarDTO("Машина 2"));
        data.add(new CarDTO("Машина 3"));
        data.add(new CarDTO("Машина 4"));
        data.add(new CarDTO("Машина 5"));
        data.add(new CarDTO("Машина 6"));
        data.add(new CarDTO("Машина 1"));
        data.add(new CarDTO("Машина 2"));
        data.add(new CarDTO("Машина 3"));
        data.add(new CarDTO("Машина 4"));
        data.add(new CarDTO("Машина 5"));
        data.add(new CarDTO("Машина 6"));
        data.add(new CarDTO("Машина 1"));
        data.add(new CarDTO("Машина 2"));
        data.add(new CarDTO("Машина 3"));
        data.add(new CarDTO("Машина 4"));
        data.add(new CarDTO("Машина 5"));
        data.add(new CarDTO("Машина 6"));

        return data;
    }
}

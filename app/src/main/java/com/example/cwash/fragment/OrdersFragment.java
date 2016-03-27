package com.example.cwash.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cwash.R;
import com.example.cwash.adapter.OrderListAdapter;
import com.example.cwash.dto.OrderDTO;

import java.util.ArrayList;
import java.util.List;

public class OrdersFragment extends Fragment {
    private static final int LAYOUT = R.layout.fragment_orders;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(LAYOUT, null);

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new OrderListAdapter(creatMockOrderListData()));

        FloatingActionButton fab = (FloatingActionButton)getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        return view;
    }


    private List<OrderDTO> creatMockOrderListData() {
        List<OrderDTO> data = new ArrayList<>();
        data.add(new OrderDTO("Honda", "16:43 23.03.2016", "М462ТР178", "500 руб."));
        data.add(new OrderDTO("Honda", "16:43 23.03.2016", "М462ТР178", "500 руб."));
        data.add(new OrderDTO("Honda", "16:43 23.03.2016", "М462ТР178", "500 руб."));
        data.add(new OrderDTO("Honda", "16:43 23.03.2016", "М462ТР178", "500 руб."));
        data.add(new OrderDTO("Honda", "16:43 23.03.2016", "М462ТР178", "500 руб."));
        data.add(new OrderDTO("Honda", "16:43 23.03.2016", "М462ТР178", "500 руб."));
        data.add(new OrderDTO("Honda", "16:43 23.03.2016", "М462ТР178", "500 руб."));
        data.add(new OrderDTO("Honda", "16:43 23.03.2016", "М462ТР178", "500 руб."));
        data.add(new OrderDTO("Honda", "16:43 23.03.2016", "М462ТР178", "500 руб."));
        data.add(new OrderDTO("Honda", "16:43 23.03.2016", "М462ТР178", "500 руб."));
        data.add(new OrderDTO("Honda", "16:43 23.03.2016", "М462ТР178", "500 руб."));
        data.add(new OrderDTO("Honda", "16:43 23.03.2016", "М462ТР178", "500 руб."));
        data.add(new OrderDTO("Honda", "16:43 23.03.2016", "М462ТР178", "500 руб."));
        return data;
    }
}

package com.example.cwash.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cwash.MainActivity;
import com.example.cwash.R;
import com.example.cwash.adapter.OrderListAdapter;
import com.example.cwash.dto.OrderDTO;

import java.util.ArrayList;
import java.util.List;

public class OrdersFragment extends Fragment {
    private static final int LAYOUT = R.layout.fragment_orders;

    public List<OrderDTO> data;

    FloatingActionButton fab;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        fab = (FloatingActionButton)getActivity().findViewById(R.id.fab);
        super.onCreate(savedInstanceState);
        data = new ArrayList<>();
    }

    @Override
    public void onResume() {
        fab.show();
        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(LAYOUT, null);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_orders);

        TextView textView = (TextView)view.findViewById(R.id.title_no_orders);

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.ordersRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        if (data.size()>0) {
            textView.setVisibility(View.GONE);
            rv.setAdapter(new OrderListAdapter(/*creatMockOrderListData()*/data));
        }
        else{
            rv.setVisibility(View.GONE);
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddOrderFragment addOrderFragment = new AddOrderFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, addOrderFragment, "ADD_ORDER_FRAG_TAG");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                getActivity().invalidateOptionsMenu();
            }
        });

        return view;
    }


    /*private List<OrderDTO> creatMockOrderListData() {
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
    }*/

}

package com.example.cwash.fragment;

import android.app.ActionBar;
import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cwash.R;
import com.example.cwash.adapter.CategoryListAdapter;
import com.example.cwash.dto.CategoryDTO;

import java.util.ArrayList;
import java.util.List;

public class CategoriesFragment extends Fragment {
    private static final int LAYOUT = R.layout.fragment_categories;

    FloatingActionButton fab;
    public List<CategoryDTO> data;

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

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_transport_category);

        TextView textView = (TextView)view.findViewById(R.id.title_no_catigories);

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.categoriesRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        if (data.size()>0) {
            textView.setVisibility(View.GONE);
            rv.setAdapter(new CategoryListAdapter(/*creatMockOrderListData()*/data));
        }
        else{
            rv.setVisibility(View.GONE);
        }

        fab = (FloatingActionButton)getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment fragment = new AddCategoryFragment();
                fragment.show(getFragmentManager(), fragment.getClass().getName());
            }
        });

        return view;
    }

    /*private List<CategoryDTO> creatMockCategoryListData() {
        List<CategoryDTO> data = new ArrayList<>();
        data.add(new CategoryDTO("Отечественный автомобиль"));
        data.add(new CategoryDTO("Иномарка"));
        data.add(new CategoryDTO("Джип"));
        return data;
    }*/
}

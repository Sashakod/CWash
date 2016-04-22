package com.example.cwash.fragment;

import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.cwash.R;
import com.example.cwash.dto.OrderDTO;

import java.util.Calendar;

public class AddOrderFragment extends Fragment {
    private static final int LAYOUT = R.layout.fragment_add_order;
    int hour;
    int minute;
    int year;
    int month;
    int day;
    EditText edit_date;
    EditText edit_time;
    EditText edit_number;


    String[] categorys = {"Легковая", "Джип", "Фургон"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(LAYOUT,null);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Добавление заказа");
        FloatingActionButton fab = (FloatingActionButton)getActivity().findViewById(R.id.fab);
        fab.hide();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categorys);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) v.findViewById(R.id.spinner_category);
        spinner.setAdapter(adapter);
        spinner.setFocusableInTouchMode(true);
        // заголовок
        spinner.setPrompt("Title");
        // выделяем элемент
        spinner.setSelection(2);

        final Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        return v;
    }

    @Override
    public void onResume() {
        edit_number = (EditText)getActivity().findViewById(R.id.edit_number);
        edit_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_number.setText("");
            }
        });
        edit_number.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        dateTampering();
        timeTampering();
        final TextView textView = (TextView) getActivity().findViewById(R.id.spinner_hint);
        Spinner spinner = (Spinner) getActivity().findViewById(R.id.spinner_category);
        spinner.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    v.performClick();
                }
            }
        });

        super.onResume();
    }

    private void timeTampering() {
        edit_time = (EditText) getActivity().findViewById(R.id.edit_time);
        edit_time.setText(hour + ":" + addNull(minute));
        edit_time.setRawInputType(InputType.TYPE_NULL);
        edit_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new TimePickerFragment();
                newFragment.show(getFragmentManager(), "timePicker");
            }
        });
        edit_time.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    DialogFragment newFragment = new TimePickerFragment();
                    newFragment.show(getFragmentManager(), "timePicker");
                }
            }
        });
    }

    private void dateTampering(){
        edit_date = (EditText)getActivity().findViewById(R.id.edit_date);
        edit_date.setText(addNull(day)+"."+addNull(month)+"."+year);
        edit_date.setRawInputType(InputType.TYPE_NULL);
        edit_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getFragmentManager(), "datePicker");
            }
        });
        edit_date.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    DialogFragment newFragment = new DatePickerFragment();
                    newFragment.show(getFragmentManager(), "datePicker");
                }
            }
        });

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_check, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private String addNull(int value){
        if (value<10)
            return "0"+value;
        else
            return String.valueOf(value);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_check: {
                OrdersFragment ordersFragment = (OrdersFragment) getFragmentManager().findFragmentByTag("ORDERS_FRAGMENT_TAG");
                EditText edit_carModel = (EditText) getActivity().findViewById(R.id.edit_carModel);
                ordersFragment.data.add(new OrderDTO(edit_carModel.getText().toString(), edit_time.getText().toString() + " "+ edit_date.getText().toString(),edit_number.getText().toString(), "500 руб."));
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, ordersFragment).commit();
            }
            break;
        }
        return true;
    }
}


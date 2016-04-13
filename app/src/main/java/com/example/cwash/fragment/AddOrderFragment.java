package com.example.cwash.fragment;

import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.cwash.R;

import java.util.Calendar;

public class AddOrderFragment extends Fragment {
    private static final int LAYOUT = R.layout.fragment_add_order;
    int hour;
    int minute;

    String[] categorys = {"Легковая", "Джип", "Фургон"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(LAYOUT,null);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categorys);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) v.findViewById(R.id.spinner_category);
        spinner.setAdapter(adapter);
        // заголовок
        spinner.setPrompt("Title");
        // выделяем элемент
        spinner.setSelection(2);

        final Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        return v;
    }

    @Override
    public void onResume() {
        timeTampering();
        super.onResume();
    }
    private void timeTampering(){
        EditText edit_time = (EditText)getActivity().findViewById(R.id.edit_time);
        edit_time.setText(hour+":"+normalizeMinute(minute));
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
    private String normalizeMinute(int minute){
        if (minute<10)
            return "0"+minute;
        else
            return String.valueOf(minute);
    }
}


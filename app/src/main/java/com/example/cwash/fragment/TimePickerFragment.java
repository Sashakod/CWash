package com.example.cwash.fragment;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

public class TimePickerFragment extends DialogFragment implements android.app.TimePickerDialog.OnTimeSetListener{
    public int hour;
    public int minute;
    AddOrderFragment orderFragment;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        orderFragment = (AddOrderFragment) getFragmentManager().findFragmentByTag("ADD_ORDER_FRAG_TAG");
        hour = orderFragment.hour;
        minute = orderFragment.minute;

        return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        orderFragment.hour = hourOfDay;
        orderFragment.minute = minute;
        orderFragment.onResume();
    }

}

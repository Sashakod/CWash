package com.example.cwash.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

public class DatePickerFragment extends DialogFragment implements android.app.DatePickerDialog.OnDateSetListener {

    int year;
    int month;
    int day;
    AddOrderFragment addOrderFragment;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        addOrderFragment = (AddOrderFragment) getFragmentManager().findFragmentByTag("ADD_ORDER_FRAG_TAG");
        year = addOrderFragment.year;
        month = addOrderFragment.month;
        day = addOrderFragment.day;
        return new DatePickerDialog(getActivity(),this,year,month,day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        addOrderFragment.year = year;
        addOrderFragment.month = monthOfYear;
        addOrderFragment.day = dayOfMonth;
        addOrderFragment.onResume();
    }
}

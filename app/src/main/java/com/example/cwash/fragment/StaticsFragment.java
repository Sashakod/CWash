package com.example.cwash.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cwash.R;
import com.example.cwash.dataBase.OrderContract;
import com.example.cwash.dataBase.OrderDBHelper;
import com.example.cwash.dto.OrderDTO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StaticsFragment extends Fragment {
    private static final int LAYOUT = R.layout.fragment_statics;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_statics,null);

        OrderDBHelper orderDBHelper = new OrderDBHelper(getActivity());
        SQLiteDatabase db = orderDBHelper.getWritableDatabase();

        /*db.delete(OrderContract.OrderEntry.TABLE_NAME,null,null);*/

        ContentValues values = new ContentValues();
        values.put(OrderContract.OrderEntry.COLUMN_NAME_CAR, "Приора");
        values.put(OrderContract.OrderEntry.COLUMN_NAME_TIME, SimpleDateFormat.getDateTimeInstance().format(new Date()));
        values.put(OrderContract.OrderEntry.COLUMN_NAME_NUMBER, "E018TP178");
        values.put(OrderContract.OrderEntry.COLUMN_NAME_PRICE, 500);

        long newRowId;
        newRowId = db.insert(OrderContract.OrderEntry.TABLE_NAME, null, values);

        db = orderDBHelper.getReadableDatabase();
        String[] projection = {
                OrderContract.OrderEntry.COLUMN_NAME_CAR,
                OrderContract.OrderEntry.COLUMN_NAME_TIME,
                OrderContract.OrderEntry.COLUMN_NAME_NUMBER,
                OrderContract.OrderEntry.COLUMN_NAME_PRICE
        };

        Cursor c = db.query(
                OrderContract.OrderEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        c.moveToFirst();
        String car = c.getString(c.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME_CAR));
        TextView textView_car = (TextView) v.findViewById(R.id.textView_car);
        textView_car.setText(car);

        String time = c.getString(c.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME_TIME));
        TextView textView_time = (TextView) v.findViewById(R.id.textView_time);
        textView_time.setText(time);

        String number = c.getString(c.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME_NUMBER));
        TextView textView_number = (TextView) v.findViewById(R.id.textView_number);
        textView_number.setText(number);

        int price = c.getInt(c.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME_PRICE));
        TextView textView_price = (TextView) v.findViewById(R.id.textView_price);
        textView_price.setText(String.valueOf(price));


        return v;
    }

}

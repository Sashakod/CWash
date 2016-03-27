package com.example.cwash.dataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public final class OrderContract {
    public OrderContract() {}

    public static abstract class OrderEntry implements BaseColumns{
        public static final String TABLE_NAME = "orders";
        /*public static final String COLUMN_NAME_ORDER_ID = "orderid";*/
        public static final String COLUMN_NAME_CAR = "car";
        public static final String COLUMN_NAME_TIME = "time";
        public static final String COLUMN_NAME_NUMBER = "number";
        public static final String COLUMN_NAME_PRICE = "price";
    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String DATATIME_TYPE = " DATATIME";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";

    public static final String SQL_CRAETE_ENTRIES =
            "CREATE TABLE " + OrderEntry.TABLE_NAME + " (" +
            OrderEntry._ID + " INTEGER PRIMARY KEY," +
            OrderEntry.COLUMN_NAME_CAR + TEXT_TYPE + COMMA_SEP +
            OrderEntry.COLUMN_NAME_TIME + DATATIME_TYPE + COMMA_SEP +
            OrderEntry.COLUMN_NAME_NUMBER + TEXT_TYPE + COMMA_SEP +
            OrderEntry.COLUMN_NAME_PRICE + INTEGER_TYPE +
            " )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + OrderEntry.TABLE_NAME;



}

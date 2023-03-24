package com.example.demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="DemoDB.db";
    public static final String TABLE_NAME="student";
    public static final String Col_1="ID";
    public static final String Col_2="NAME";
    public static final String Col_3="Phone";
    public static final String Col_4="Address";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENt , NAME TEXT , PHONE INTEGER , ADDRESS TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE EXITS"+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String name, String phone, String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_2, name);
        contentValues.put(Col_3, phone);
        contentValues.put(Col_4, address);
        long res = db.insert(TABLE_NAME, null, contentValues);
        if (res==-1)
        {
            return false;
        }
        else {
            return true;
        }
    }
}

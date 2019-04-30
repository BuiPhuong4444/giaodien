package com.example.employeemanager.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DB_ValueLuong extends SQLiteOpenHelper {
    private static final String DATABASE_NAME= "employeeManager";
    private static final int DATABASE_VERSION=1;

    public static final String TABLE_NAME="ValueLuong";//tên bảng
    public static final String COLUMN_ID ="id_value";
    public static final String COLUMN_VALUE ="value";


    public DB_ValueLuong(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.onCreate(this.getReadableDatabase());

//        SQLiteDatabase db= this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(this.COLUMN_ID, 1);
//        values.put(this.COLUMN_VALUE, "0");
//        db.insert(this.TABLE_NAME, null, values);
//
//        ContentValues values1 = new ContentValues();
//        values1.put(this.COLUMN_ID, 2);
//        values1.put(this.COLUMN_VALUE, "0");
//        db.insert(this.TABLE_NAME, null, values1);
//
//        ContentValues values2 = new ContentValues();
//        values2.put(this.COLUMN_ID, 3);
//        values2.put(this.COLUMN_VALUE, "0");
//        db.insert(this.TABLE_NAME, null, values2);
//
//        db.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql= "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( "+ COLUMN_ID +" INTEGER " + " PRIMARY KEY ," + COLUMN_VALUE + " TEXT)";
        db.execSQL(sql);//chay lenh tao bang


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }
}

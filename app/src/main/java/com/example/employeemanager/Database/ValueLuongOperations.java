package com.example.employeemanager.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.employeemanager.model.NhanVien;
import com.example.employeemanager.model.ValueLuong;

import java.util.ArrayList;

public class ValueLuongOperations {
    public static final String LOGTAG= "EMP_DB";
    DB_ValueLuong db_valueLuong;
    SQLiteDatabase database;

    private static final String[] allColumns ={
           DB_ValueLuong.COLUMN_ID,
            DB_ValueLuong.COLUMN_VALUE
    };
    public ValueLuongOperations(Context context){
        db_valueLuong = new DB_ValueLuong(context);
        open();
    }

    public void open(){
        Log.i(LOGTAG,"Database Opened");
        database= db_valueLuong.getWritableDatabase();
    }
    public void close(){
        Log.i(LOGTAG, "Database Closed");
        db_valueLuong.close();
    }

//    //them giá  trị
    public void adđValue(ValueLuong valueLuong){
       database = db_valueLuong.getWritableDatabase();
       ContentValues values = new ContentValues();
       values.put(DB_ValueLuong.COLUMN_VALUE, valueLuong.getValue());
       database.insert(DB_ValueLuong.TABLE_NAME, null, values);
       database.close();
   }

    //update value
    public void updateValue(ValueLuong valueLuong){
        ContentValues values= new ContentValues();
        values.put(DB_ValueLuong.COLUMN_VALUE, valueLuong.getValue());
        //update row
        database.update(DB_ValueLuong.TABLE_NAME, values, DB_ValueLuong.COLUMN_ID + "=?", new String[]{String.valueOf(valueLuong.getId_value())});

    }

    //tra ve cac ban ghi
//    public ArrayList<ValueLuong> getValueLuongs(){
//        if(database != null) {
//            Cursor cursor = database.rawQuery("SELECT " + DB_ValueLuong.COLUMN_ID + "," + DB_ValueLuong.COLUMN_VALUE + " FROM " + DB_ValueLuong.TABLE_NAME,null);
//            ArrayList<ValueLuong> valueLuongs = new ArrayList<>();
//            while (cursor.moveToNext()) {
//                ValueLuong valueLuong = new ValueLuong();
//                valueLuong.setId_value(cursor.getInt(0));
//                valueLuong.setValue(cursor.getInt(1));
//
//                valueLuongs.add(valueLuong);
//            }
//            return valueLuongs;
//        }
//        return null;
//    }


    //get single ValueLuong
    public ValueLuong getValueLuong(int id){
        database = db_valueLuong.getReadableDatabase();
        Cursor cursor = database.query(DB_ValueLuong.TABLE_NAME, allColumns,DB_ValueLuong.COLUMN_ID + "=?", new String[]{String.valueOf((id))}, null, null,null);
        if(cursor!=null){
            cursor.moveToFirst();

        }
        ValueLuong valueLuong= new ValueLuong(Integer.parseInt(cursor.getString(0)),  cursor.getString(1));
        return valueLuong;
    }
}

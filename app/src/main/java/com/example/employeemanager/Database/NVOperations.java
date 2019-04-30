package com.example.employeemanager.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.employeemanager.model.NhanVien;

import java.util.ArrayList;

public class NVOperations{
    public static final String LOGTAG= "EMP_DB";
     DBNhanVien dbNhanVien;
     SQLiteDatabase database;

     private static final String[] allColumns ={
             DBNhanVien.COLUMN_ID,
             DBNhanVien.COLUMN_NAME,
             DBNhanVien.COLUMN_SDT,
             DBNhanVien.COLUMN_ADDRESS,
             DBNhanVien.COLUMN_BIRTH,
             DBNhanVien.COLUMN_DATEBEGIN,
             DBNhanVien.COLUMN_EMAIL
     };
     public NVOperations(Context context){
         dbNhanVien = new DBNhanVien(context);
         open();
     }

    public void open(){
         Log.i(LOGTAG,"Database Opened");
         database= dbNhanVien.getWritableDatabase();
     }
     public void close(){
         Log.i(LOGTAG, "Database Closed");
         dbNhanVien.close();
     }

     //them nhan vien
     public void addNhanVien(NhanVien nhanVien){
         int id=1;
        //database.close();
         database = dbNhanVien.getReadableDatabase();
         Cursor cursor = database.rawQuery("SELECT max(" + DBNhanVien.COLUMN_ID + ") FROM " + DBNhanVien.TABLE_NAME,null);
         if(cursor != null && cursor.moveToFirst()){
             id = cursor.getInt(0) + 1;
             Log.i("Ma NV",""+id );
         }
         database.close();
         database = dbNhanVien.getWritableDatabase();
         ContentValues values= new ContentValues();
         nhanVien.setMaNV(id);
         values.put(DBNhanVien.COLUMN_ID,nhanVien.getMaNV());
         values.put(DBNhanVien.COLUMN_NAME, nhanVien.getTenNV());
         values.put(DBNhanVien.COLUMN_SDT, nhanVien.getSdt());
         values.put(DBNhanVien.COLUMN_ADDRESS, nhanVien.getDiaChi());
         values.put(DBNhanVien.COLUMN_BIRTH, nhanVien.getNgaySinh());
         values.put(DBNhanVien.COLUMN_DATEBEGIN, nhanVien.getNgayBD());
         values.put(DBNhanVien.COLUMN_EMAIL, nhanVien.getEmail());
         Log.i("Thêm NV:", nhanVien.toString());
         database.insert(DBNhanVien.TABLE_NAME, null,values);
     }
     //get single NhanVien
    public NhanVien getNhanVien(int id){
        Cursor cursor = database.query(DBNhanVien.TABLE_NAME, allColumns,DBNhanVien.COLUMN_ID + "=?", new String[]{String.valueOf((id))}, null, null,null);
        if(cursor!=null){
            cursor.moveToFirst();

        }
        NhanVien nhanVien= new NhanVien(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3),cursor.getString(4), cursor.getString(5),cursor.getString(6));
        return nhanVien;
    }

    //danh sach nhan vien (get all NV)
    public ArrayList<NhanVien> getAllNhanVien(){
         if(database != null) {
             Cursor cursor = database.rawQuery("SELECT " + DBNhanVien.COLUMN_NAME + "," + DBNhanVien.COLUMN_SDT + "," + DBNhanVien.COLUMN_EMAIL+ "," + DBNhanVien.COLUMN_ADDRESS+ "," + DBNhanVien.COLUMN_BIRTH+ "," + DBNhanVien.COLUMN_DATEBEGIN+ "," + DBNhanVien.COLUMN_ID + " FROM " + DBNhanVien.TABLE_NAME,null);
             ArrayList<NhanVien> nhanVienList = new ArrayList<>();
                 while (cursor.moveToNext()) {
                     NhanVien nhanVien = new NhanVien();
                     nhanVien.setTenNV(cursor.getString(0));//ten
                     nhanVien.setSdt(cursor.getString(1));//sdt
                     nhanVien.setEmail(cursor.getString(2));
                     nhanVien.setDiaChi(cursor.getString(3));
                     nhanVien.setNgaySinh(cursor.getString(4));
                     nhanVien.setNgayBD(cursor.getString(5));
                     nhanVien.setMaNV(cursor.getInt(6));
                     nhanVienList.add(nhanVien);
                 }
             return nhanVienList;
         }
         return null;
     }

     //update nhan vien
    public void updateNhanVien(NhanVien nhanVien){
        ContentValues values= new ContentValues();
        values.put(DBNhanVien.COLUMN_NAME, nhanVien.getTenNV());
        values.put(DBNhanVien.COLUMN_SDT, nhanVien.getSdt());
        values.put(DBNhanVien.COLUMN_ADDRESS, nhanVien.getDiaChi());
        values.put(DBNhanVien.COLUMN_BIRTH, nhanVien.getNgaySinh());
        values.put(DBNhanVien.COLUMN_DATEBEGIN,nhanVien.getNgayBD());
        values.put(DBNhanVien.COLUMN_EMAIL, nhanVien.getEmail());

        //update row
        database.update(DBNhanVien.TABLE_NAME, values, DBNhanVien.COLUMN_ID + "=?", new String[]{String.valueOf(nhanVien.getMaNV())});

    }

    //xoa nhan vien
    public void removeNhanVien(NhanVien nhanVien){
        database.delete(DBNhanVien.TABLE_NAME, DBNhanVien.COLUMN_ID + "="+ nhanVien.getMaNV(), null);
    }

}

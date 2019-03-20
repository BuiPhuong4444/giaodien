package com.example.employeemanager.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBNhanVien extends SQLiteOpenHelper {
    private static final String DATABASE_NAME= "employeeManager";
    private static final int DATABASE_VERSION=1;
    private static final String TABLE_NAME="employees";

    private static final String COLUMN_ID ="id";
    private static final String COLUMN_NAME ="hoTen";
    private static final String COLUMN_EMAIL="email";
    private static final String COLUMN_SDT ="sdt";
    private static final String COLUMN_ADDRESS ="diaChi";
    private static final String COLUMN_BIRTH ="ngaySinh";
    private static final String COLUMN_DATEBEGIN ="ngayBD";
    private static final String COLUMN_LUONG ="luongCB";
    private static final String COLUMN_ANH ="anh";


    public DBNhanVien( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {//cần viết để tạo bảng
        String sql= String.format("CREATE TABLE %s (%s INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT,%s TEXT,%s BLOB,%s SNUERIC,%s INTEGER, %s REAL, %s TEXT)", TABLE_NAME, COLUMN_ID,COLUMN_NAME, COLUMN_SDT, COLUMN_ADDRESS, COLUMN_ANH, COLUMN_BIRTH, COLUMN_DATEBEGIN,COLUMN_LUONG,COLUMN_EMAIL );
        db.execSQL(sql);//chay lenh tao bang
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {//phương thức được goiij khi thay đổi csdl
    //huy bang cu neu no da ton tai
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        //và tạo lại
        onCreate(db);
    }
}

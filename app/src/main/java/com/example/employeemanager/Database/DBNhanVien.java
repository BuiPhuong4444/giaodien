package com.example.employeemanager.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBNhanVien extends SQLiteOpenHelper {
    private static final String DATABASE_NAME= "employeeManager";
    private static final int DATABASE_VERSION=1;

    public static final String TABLE_NAME="employees";//tên bảng
    public static final String COLUMN_ID ="id";
    public static final String COLUMN_NAME ="hoTen";
    public static final String COLUMN_EMAIL="email";
    public static final String COLUMN_SDT ="sdt";
    public static final String COLUMN_ADDRESS ="diaChi";
    public static final String COLUMN_BIRTH ="ngaySinh";
    public static final String COLUMN_DATEBEGIN ="ngayBD";



    public DBNhanVien( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.onCreate(this.getReadableDatabase());
    }

    @Override
    public void onCreate(SQLiteDatabase db) {//cần viết để tạo bảng
        String sql= "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( "+ COLUMN_ID +" INTEGER " + " PRIMARY KEY," + COLUMN_NAME + " VARCHAR(40),"+ COLUMN_ADDRESS +" VARCHAR(40),"+ COLUMN_SDT +" VARCHAR(40),"+ COLUMN_BIRTH+" DATE,"+ COLUMN_DATEBEGIN+" DATE,"+ COLUMN_EMAIL+" VARCHAR(40))";
        db.execSQL(sql);//chay lenh tao bang
      //  db.close();
    }

    public void DelTable()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {//phương thức được goiij khi thay đổi csdl
    //huy bang cu neu no da ton tai
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        //và tạo lại
       onCreate(db);
    }

    //them nhan vien

}

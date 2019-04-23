package com.example.employeemanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;

public class ThemNVActivity extends Activity {

    EditText edtHoTen, edtSDT, edtEmail, edtDChi, edtNSinh, edtNgayBD, edtLuongCB;
    DatePickerDialog datePickerDialog;
//    ImageView imgAnh;
//    byte[] anh;
    String hoTen, sdt, email, diaChi, NSinh, NgayBD, LuongCB;
    final String DATABASE_NAME= "employeeManager";
     //bien tu tang ma NV
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nv);

        edtHoTen = (EditText) this.findViewById(R.id.editText2);
        hoTen =  edtHoTen.getText().toString();

        edtSDT = (EditText) this.findViewById(R.id.editText4);
        sdt= edtSDT.getText().toString();

        edtDChi = (EditText)this.findViewById(R.id.editText6);
        diaChi = edtDChi.getText().toString();

        edtEmail = (EditText)this.findViewById(R.id.editText5);
        email = edtEmail.getText().toString();

        edtNSinh =(EditText) this.findViewById(R.id.editText7);
      //  NSinh = edtNSinh.getText().toString();
        //click chọn ngày sinh
        edtNSinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c= Calendar.getInstance();
                int mYear= c.get(Calendar.YEAR);
                int mMonth= c.get(Calendar.MONTH);
                int mDay= c.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(ThemNVActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        edtNSinh.setText(dayOfMonth+"/"+(month +1)+"/"+year);

                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        edtNgayBD = (EditText)this.findViewById(R.id.editText8);
       // NgayBD = edtNgayBD.getText().toString();
        //click chỌn ngày bđ
        edtNgayBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c= Calendar.getInstance();
                int mYear= c.get(Calendar.YEAR);
                int mMonth= c.get(Calendar.MONTH);
                int mDay= c.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(ThemNVActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        edtNgayBD.setText(dayOfMonth+"/"+(month +1)+"/"+year);

                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        edtLuongCB = (EditText)this.findViewById(R.id.editText9);
        LuongCB= edtLuongCB.getText().toString();

//        imgAnh= (ImageView) this.findViewById(R.id.imageView);
//        anh = ConverttoArrayByte(imgAnh) ;



//

        //chuyen den man hinh Menu khi Khong them
        Button btn4= (Button) this.findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4= new Intent(ThemNVActivity.this, MenuActivity.class);
                ThemNVActivity.this.startActivity(intent4);
            }
        });
//
//        //xu ly khi button THEM

//        Button btn3= (Button) this.findViewById(R.id.button3);
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //xu ly thong tin dau vao
//                if(hoTen.length()==0){//nếu không nhập họ tên không cho thêm
//                    Toast.makeText(ThemNVActivity.this,"Nhập tên nhân viên",Toast.LENGTH_LONG).show();
//                }
//                else {
//
//                    //them du lieu vao DB
//
//                    //hien thi thong bao khi them thanh cong su dung TOAST
//                    Toast.makeText(ThemNVActivity.this, "Đã thêm thành công!", Toast.LENGTH_LONG).show();
//                }
//            }
//        });
    }

//    //hàm chuyển đổi từ kiểu bitmap sang byte[] để lưu vào DB

//    protected byte[] ConverttoArrayByte(ImageView img){
//        BitmapDrawable bitmapDrawable= (BitmapDrawable)img.getDrawable();
//        Bitmap bitmap = bitmapDrawable.getBitmap();
//        ByteArrayOutputStream stream= new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
//        return stream.toByteArray();
//    }
}

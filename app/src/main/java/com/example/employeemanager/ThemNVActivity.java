package com.example.employeemanager;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.employeemanager.Database.NVOperations;
import com.example.employeemanager.model.NhanVien;

import java.util.Calendar;

public class ThemNVActivity extends Activity {

    Context context;
    EditText edtHoTen, edtSDT, edtEmail, edtDChi, edtNSinh, edtNgayBD;
    DatePickerDialog datePickerDialog;
    private NVOperations nvOperations;

    String hoTen, sdt, email, diaChi, NSinh, NgayBD;
    final String DATABASE_NAME= "employeeManager";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nv);
        this.context = this;
        edtHoTen = (EditText) this.findViewById(R.id.editText2);
        edtSDT = (EditText) this.findViewById(R.id.editText4);
        edtDChi = (EditText)this.findViewById(R.id.editText6);
        edtEmail = (EditText)this.findViewById(R.id.editText5);
        edtNSinh =(EditText) this.findViewById(R.id.editText7);
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


        //edtLuongCB = (EditText)this.findViewById(R.id.editText9);



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

        Button btn3= (Button) this.findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //xu ly thong tin dau vao
                hoTen =  edtHoTen.getText().toString();
                sdt= edtSDT.getText().toString();
                email = edtEmail.getText().toString();
                NSinh = edtNSinh.getText().toString();
                NgayBD = edtNgayBD.getText().toString();
                diaChi = edtDChi.getText().toString();
                if(hoTen.isEmpty() || sdt.isEmpty() || diaChi.isEmpty() || NgayBD.isEmpty() ){//nếu không nhập họ tên không cho thêm
                    Toast.makeText(ThemNVActivity.this,"Nhập tên nhân viên",Toast.LENGTH_LONG).show();
                }
                else {

                    //them du lieu vao DB
                    NhanVien nhanVien= new NhanVien(hoTen,sdt,diaChi,NSinh,NgayBD,email);
                    NVOperations nvOperations = new NVOperations(context);
                    nvOperations.addNhanVien(nhanVien);
                    nvOperations.close();
                    //hien thi thong bao khi them thanh cong su dung TOAST
                    Toast.makeText(ThemNVActivity.this, "Đã thêm thành công!", Toast.LENGTH_LONG).show();
                    Intent intent5= new Intent(ThemNVActivity.this, MenuActivity.class);
                    ThemNVActivity.this.startActivity(intent5);
                }

            }
        });
    }




}

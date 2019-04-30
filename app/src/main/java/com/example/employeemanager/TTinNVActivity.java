package com.example.employeemanager;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.employeemanager.Database.NVOperations;
import com.example.employeemanager.model.NhanVien;

import java.util.Calendar;

public class TTinNVActivity extends Activity {

    private NVOperations nvOperations;
    EditText txtName, txtPhone, txtAddr, txtEmail, txtBirth,txtHireDate;

    Button btnUpdate, btnDelete, btnCancel;
    String hoTen, sdt, email, diaChi, NSinh, NgayBD;
    Context context;
    DatePickerDialog datePickerDialog;
    final String DATABASE_NAME= "employeeManager";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttin_nv);
        this.context= this;


        txtName = (EditText) this.findViewById(R.id.edit_name);
        txtPhone = (EditText) this.findViewById(R.id.edit_phone);
        txtAddr = (EditText) this.findViewById(R.id.edit_addr);
        txtEmail = (EditText) this.findViewById(R.id.edit_email);
        txtBirth = (EditText) this.findViewById(R.id.edit_birth);
        txtHireDate = (EditText) this.findViewById(R.id.edit_hireDate);
        btnDelete = (Button) this.findViewById(R.id.btn_delete);
        btnUpdate = (Button) this.findViewById(R.id.btn_update);
        btnCancel = (Button) this.findViewById(R.id.btn_cancel);

        //hiển thị thông tin của nhân viên tại vị trí postion
        nvOperations =new NVOperations(this);
        nvOperations.open();
        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        if(bundle != null){
            NhanVien nhanVien = new NhanVien();

            int IdNV= bundle.getInt("id", 0);
            nhanVien.setMaNV(IdNV);
            Log.i("MNS", ""+IdNV);
            txtName.setText(bundle.getString("name", " "));
            txtPhone.setText(bundle.getString("phone", " "));
            txtAddr.setText(bundle.getString("addr", " "));
            txtEmail.setText(bundle.getString("email", " "));
            txtBirth.setText(bundle.getString("birth", " "));
            txtHireDate.setText(bundle.getString("hireDate", " "));

        }

        //get dữ liệu
        //click chọn ngày sinh
        txtBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c= Calendar.getInstance();
                int mYear= c.get(Calendar.YEAR);
                int mMonth= c.get(Calendar.MONTH);
                int mDay= c.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(TTinNVActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        txtBirth.setText(dayOfMonth+"/"+(month +1)+"/"+year);

                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        //click chỌn ngày bđ
        txtHireDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c= Calendar.getInstance();
                int mYear= c.get(Calendar.YEAR);
                int mMonth= c.get(Calendar.MONTH);
                int mDay= c.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(TTinNVActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        txtHireDate.setText(dayOfMonth+"/"+(month +1)+"/"+year);

                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });


        //sự kiện button update
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hoTen =  txtName.getText().toString();
                sdt= txtPhone.getText().toString();
                email = txtEmail.getText().toString();
                NSinh = txtBirth.getText().toString();
                NgayBD = txtHireDate.getText().toString();
                diaChi = txtAddr.getText().toString();
                if(hoTen.length()==0 && sdt.length() ==0 && NgayBD.length()==0 && diaChi.length() ==0 && NSinh.length()==0 ){//nếu không nhập họ tên không cho thêm
                    Toast.makeText(TTinNVActivity.this,"Nhập tên nhân viên",Toast.LENGTH_LONG).show();
                }
                else {

                    //update du lieu vao DB
                    NhanVien nhanVien= new NhanVien(hoTen,sdt,diaChi,NSinh,NgayBD,email);
                    int IdNV= bundle.getInt("id", 0);
                    nhanVien.setMaNV(IdNV);
                    nvOperations = new NVOperations(context);
                    nvOperations.updateNhanVien(nhanVien);

                    //hien thi thong bao khi them thanh cong su dung TOAST
                    Toast.makeText(TTinNVActivity.this, "Đã cập nhật thành công!", Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(TTinNVActivity.this, DSNVActivity.class);
                    TTinNVActivity.this.startActivity(intent);
                }
            }
        });
        //sự kiện button xóa
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hoTen =  txtName.getText().toString();
                sdt= txtPhone.getText().toString();
                email = txtEmail.getText().toString();
                NSinh = txtBirth.getText().toString();
                NgayBD = txtHireDate.getText().toString();
                diaChi = txtAddr.getText().toString();
                NhanVien nhanVien= new NhanVien(hoTen,sdt,diaChi,NSinh,NgayBD,email);
                int IdNV= bundle.getInt("id", 0);
                nhanVien.setMaNV(IdNV);
                nvOperations = new NVOperations(context);
                nvOperations.removeNhanVien(nhanVien);
                Toast.makeText(TTinNVActivity.this, "Đã xóa thành công!", Toast.LENGTH_LONG).show();
                Intent intent= new Intent(TTinNVActivity.this, DSNVActivity.class);
                TTinNVActivity.this.startActivity(intent);
            }
        });

        //su kien button cancel
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(TTinNVActivity.this, DSNVActivity.class);
                TTinNVActivity.this.startActivity(intent);
            }
        });
    }
}

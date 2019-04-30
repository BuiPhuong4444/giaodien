package com.example.employeemanager;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.employeemanager.Database.NVOperations;
import com.example.employeemanager.model.NhanVien;

import java.util.ArrayList;

public class DKLichLVActivity extends Activity {
    //Operation Chấm công

    //button radio

    //
    private NVOperations nvOperations;
    TextView tviewName, tviewphone, tviewAddress, tviewDate;
    Button btUpdate, btCancel;
    String hoTen, sdt, diaChi;
    Context context;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dklich_lv);
        this.context= this;

        tviewName = (TextView) this.findViewById(R.id.textView8);
        tviewphone = (TextView) this.findViewById(R.id.textView10);
        tviewAddress = (TextView) this.findViewById(R.id.textView9);
        tviewDate = (TextView) this.findViewById(R.id.textView13);
        btUpdate = (Button) this.findViewById(R.id.button7);
        btCancel = (Button) this.findViewById(R.id.button8);

        nvOperations =new NVOperations(this);
        nvOperations.open();
        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        if(bundle != null){
            tviewName.setText(bundle.getString("name", " "));
            tviewphone.setText(bundle.getString("phone", " "));
            tviewAddress.setText(bundle.getString("addr", " "));
            //hiển thị ngày (date) vao tviewDate

            //xử lý button radio (time)

            //sự kiện button update
            btUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //id_dd, id_nv, date, time: 1 ngày nhân viên được điểm danh một lần
                    NhanVien nhanVien = new NhanVien();

                    int IdNV= bundle.getInt("id", 0);
                    nhanVien.setMaNV(IdNV);
                    // điểm danh xong hiển thị danh sách
                    Intent intent= new Intent(DKLichLVActivity.this, ListActivity.class);
                    DKLichLVActivity.this.startActivity(intent);
                }
            });
            //sự kiện button Cancel
            btCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(DKLichLVActivity.this, ListActivity.class);
                    DKLichLVActivity.this.startActivity(intent);
                }
            });
        }


    }
}

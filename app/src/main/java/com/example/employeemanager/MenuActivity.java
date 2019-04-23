package com.example.employeemanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //them nhan vien
        Button btn12= (Button) this.findViewById(R.id.button12);
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chuyen den ThemNV
                Intent intent12= new Intent(MenuActivity.this, ThemNVActivity.class);
                startActivity(intent12);
                Log.i("chuyển đến mh thêm","jid");

            }
        });
        //DSNV
        Button btn13= (Button) this.findViewById(R.id.button13);
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chuyen den DSNV

                //sau khi chon NV trong DS hien thi thong tin cua tung  NV
                Intent intent13 = new Intent(MenuActivity.this, DSNVActivity.class);
                MenuActivity.this.startActivity(intent13);
            }
        });
        //DK Lich LV
        Button btn14 = (Button) this.findViewById(R.id.button14);
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chuyen  den DKLichLV
                Intent intent14= new Intent(MenuActivity.this, DKLichLVActivity.class);
                MenuActivity.this.startActivity(intent14);
            }
        });
        //Tinh Luong
        Button btn15= (Button) this.findViewById(R.id.button15);
        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chuyen den TinhLuong
                Intent intent15= new Intent(MenuActivity.this, TinhLuongActivity.class);
                MenuActivity.this.startActivity(intent15);
            }
        });
        //SetValue
        Button btn16= (Button) this.findViewById(R.id.button16);
        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chuyen den SetValue
                Intent intent16= new Intent(MenuActivity.this, SetValueActivity.class);
                MenuActivity.this.startActivity(intent16);
            }
        });
    }
}

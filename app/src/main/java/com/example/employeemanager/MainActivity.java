package com.example.employeemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1=(Button) this.findViewById(R.id.btnSetMK);
        button1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tao mot Intent mang nooij dung gui den Nhap mat khau
                Intent myIntent= new Intent(MainActivity.this,DangNhapActivity.class);
                //cac tham so gan tren Intent
                //yeu cau chay DangNhap
                MainActivity.this.startActivity(myIntent);
            }
        });
    }
}

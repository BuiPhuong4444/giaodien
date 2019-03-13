package com.example.employeemanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThemNVActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nv);

        //chuyen den man hinh Menu khi Khong them
        Button btn4= (Button) this.findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4= new Intent(ThemNVActivity.this, MenuActivity.class);
                ThemNVActivity.this.startActivity(intent4);
            }
        });
        //xu ly khi button THEM
        Button btn3= (Button) this.findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //xu ly thong tin dau vao

                //hien thi thong bao khi them thanh cong su dung TOAST
                Toast.makeText(ThemNVActivity.this,"Đã thêm thành công!",Toast.LENGTH_LONG).show();

            }
        });
    }
}

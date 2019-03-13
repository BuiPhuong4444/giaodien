package com.example.employeemanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DangNhapActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        Button btn2= (Button)this.findViewById(R.id.button2);
        btn2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kiem tra mat khau co dung voi luc dang ky khong
                //neu sai chuyen ve man ban dau
                Intent noDNIntent= new Intent(DangNhapActivity.this, MainActivity.class);
                DangNhapActivity.this.startActivity(noDNIntent);
                //neu dung chuyen toi Menu
                Intent dangNhapIntent= new Intent(DangNhapActivity.this, MenuActivity.class);
                DangNhapActivity.this.startActivity(dangNhapIntent);
            }
        });
    }
}

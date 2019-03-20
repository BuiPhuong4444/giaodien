package com.example.employeemanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DangNhapActivity extends Activity {
    EditText edtPassword;
    String str_Password, str_getPassword;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        btn2= (Button)this.findViewById(R.id.button2);
        edtPassword = (EditText) this.findViewById(R.id.editText3);
        str_getPassword = MainActivity.shpf.getString("password", null);
        btn2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kiem tra mat khau co dung voi luc dang ky khong
                str_Password= edtPassword.getText().toString();
                if (str_Password.length() ==0){
                    Toast.makeText(getApplicationContext(),"Nhập mật khẩu", Toast.LENGTH_LONG).show();

                }
                else if (!(str_getPassword.matches(str_Password))){
                    Toast.makeText(getApplicationContext(),"Mật khẩu không đúng",Toast.LENGTH_LONG).show();

                }
                else if (str_getPassword.matches(str_Password)){
                    Toast.makeText(getApplicationContext(),"Đăng nhập thành công",Toast.LENGTH_LONG).show();
                    // chuyen toi Menu
                    Intent dangNhapIntent= new Intent(DangNhapActivity.this, MenuActivity.class);
                    DangNhapActivity.this.startActivity(dangNhapIntent);
                }

            }
        });
    }
}

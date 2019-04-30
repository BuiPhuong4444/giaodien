package com.example.employeemanager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DangNhapActivity extends Activity {
    EditText edtPassword;
    String str_Password, str_getPassword;
    Button btn2;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private final static String NAME ="savepass";
    private final static String KEY="loginTest";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        btn2= (Button)this.findViewById(R.id.button2);
        edtPassword = (EditText) this.findViewById(R.id.editText3);
        sharedPreferences = getSharedPreferences(NAME, Context.MODE_PRIVATE);

        str_getPassword = sharedPreferences.getString(KEY,"");
        if(str_getPassword == ""){
            Intent mIntent = new Intent(DangNhapActivity.this, MainActivity.class);
            startActivity(mIntent);
        }
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
                    startActivity(dangNhapIntent);
                }

            }
        });
    }
}

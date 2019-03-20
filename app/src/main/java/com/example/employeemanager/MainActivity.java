package com.example.employeemanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static int pasword;
    EditText password;
    Button button1;
    String strPassword;
    public static String str_login;
    //su dung SharedPreference de lưu mat khau
    public static SharedPreferences shpf; //de luu tru du lieu
    public static SharedPreferences.Editor editor;//de mo file va dua du lieu vao

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //khoi tao mot doi tuong
        shpf = getSharedPreferences("savepass", Context.MODE_PRIVATE);//luu vao file, va chi cho pheo ung dung truy nhap
        editor = shpf.edit();

        str_login = shpf.getString("loginTest", null);


        button1=(Button) this.findViewById(R.id.btnSetMK);
        password = (EditText) findViewById(R.id.editSetMK);
        button1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                strPassword = password.getText().toString();
                if(strPassword.length() != 6){
                    Toast.makeText(getApplicationContext(),"Mật khẩu gồm 6 chữ số", Toast.LENGTH_LONG);
                }
                else {
                    MainActivity.editor.putString("password",strPassword);
                    MainActivity.editor.commit();
                    Toast.makeText(getApplicationContext(), "CÀi đặt mật khẩu thành công", Toast.LENGTH_LONG).show();
                    //tao mot Intent mang noi dung gui den Nhap mat khau
                    Intent myIntent= new Intent(MainActivity.this,DangNhapActivity.class);
                    //cac tham so gan tren Intent
                    //yeu cau chay DangNhap
                    MainActivity.this.startActivity(myIntent);
                }

            }
        });
    }
}

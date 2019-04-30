package com.example.employeemanager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.employeemanager.Database.ValueLuongOperations;
import com.example.employeemanager.model.ValueLuong;

public class SetValueActivity extends Activity {
    EditText edit_value1, edit_value2;
    Button btnUpdate, btnExit;
    private ValueLuongOperations valueLuongOperations;
    String cn, nn;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_value);
        this.context = this;
        edit_value1 = (EditText) this.findViewById(R.id.editText20);
        edit_value2 =  (EditText) this.findViewById(R.id.editText21);
        btnUpdate = (Button) this.findViewById(R.id.button10);
        btnExit =(Button)this.findViewById(R.id.button11);

        valueLuongOperations = new ValueLuongOperations(this);
        valueLuongOperations.open();
//////////////////////////////////
        //kiem tra bang TABLE_NAME="ValueLuong"
        //neu da co ban ghi thi hien thi gia tri set cho edittext


        //su kien button update
//        btnUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //kiem tra bang TABLE_NAME="ValueLuong"
//
//                //neu chua co ban ghi nao thi them
//                if(){
//
//
//                    Toast.makeText(SetValueActivity.this, "SetValue success!", Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(SetValueActivity.this, MenuActivity.class);
//                    SetValueActivity.this.startActivity(intent);
//                }
//                //neu da co thi update lai
//                else{
//
//                    Toast.makeText(SetValueActivity.this, "SetValue success!", Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(SetValueActivity.this, MenuActivity.class);
//                    SetValueActivity.this.startActivity(intent);
//                }
//
//            }
//        });
/////////////////////////////
        //su hien button exit
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetValueActivity.this, MenuActivity.class);
                SetValueActivity.this.startActivity(intent);
            }
        });
    }
}

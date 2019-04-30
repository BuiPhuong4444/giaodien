package com.example.employeemanager;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.employeemanager.Database.NVOperations;
import com.example.employeemanager.model.NhanVien;

import java.util.Calendar;

public class TinhLuongActivity extends Activity {

    //
    private NVOperations nvOperations;
    TextView tviewName, tviewphone, tviewAddress, tviewCN, tviewNN, tviewTT;
    EditText edtDate1, edtDate2;
    Button btView, btCancel,btTT;
    String hoTen, sdt, diaChi;
    Context context;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinh_luong);

        tviewName = (TextView) this.findViewById(R.id.text_name);
        tviewphone = (TextView) this.findViewById(R.id.textView_phone);
        tviewAddress = (TextView) this.findViewById(R.id.textView_addr);
        tviewCN = (TextView) this.findViewById(R.id.textViewCN);
        tviewNN = (TextView) this.findViewById(R.id.textViewNN);
        tviewTT = (TextView) this.findViewById(R.id.textViewTT);
        edtDate1 = (EditText) this.findViewById(R.id.editTextDate1);
        edtDate2 = (EditText) this.findViewById(R.id.editTextDate2);
        btCancel = (Button) this.findViewById(R.id.buttonCancel);
        btTT = (Button) this.findViewById(R.id.buttonTT);
        btView = (Button) this.findViewById(R.id.buttonView);

        nvOperations =new NVOperations(this);
        nvOperations.open();
        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        if(bundle != null){
            tviewName.setText(bundle.getString("name", " "));
            tviewphone.setText(bundle.getString("phone", " "));
            tviewAddress.setText(bundle.getString("addr", " "));

            //ngay bat dau
            edtDate1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Calendar c= Calendar.getInstance();
                    int mYear= c.get(Calendar.YEAR);
                    int mMonth= c.get(Calendar.MONTH);
                    int mDay= c.get(Calendar.DAY_OF_MONTH);

                    datePickerDialog = new DatePickerDialog(TinhLuongActivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                            edtDate1.setText(dayOfMonth+"/"+(month +1)+"/"+year);

                        }
                    }, mYear, mMonth, mDay);
                    datePickerDialog.show();
                }
            });

            //ngay ket thuc

            edtDate2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Calendar c= Calendar.getInstance();
                    int mYear= c.get(Calendar.YEAR);
                    int mMonth= c.get(Calendar.MONTH);
                    int mDay= c.get(Calendar.DAY_OF_MONTH);

                    datePickerDialog = new DatePickerDialog(TinhLuongActivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                            edtDate2.setText(dayOfMonth+"/"+(month +1)+"/"+year);

                        }
                    }, mYear, mMonth, mDay);
                    datePickerDialog.show();
                }
            });

            //xu ly button xem

            btView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //select tu bang diem danh de hien thi so ngay di lam nua ngay va ca ngay ca ngay va tinh ra so tien
                    //hien thi ngay tai activity hien tai
                }
            });

            //xu ly button thanh toan
            btTT.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //xoa cac ban ghi thoa man dieu kien lay tu button xem

                    //quay tro lai man hình danh sach
                    Intent intent= new Intent(TinhLuongActivity.this, List2Activity.class);
                    TinhLuongActivity.this.startActivity(intent);
                }
            });

            //xu ly button EXIT
            btCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(TinhLuongActivity.this, List2Activity.class);
                    TinhLuongActivity.this.startActivity(intent);
                }
            });
        }




    }
}

package com.example.employeemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.employeemanager.Database.NVOperations;
import com.example.employeemanager.model.NhanVien;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    private NVOperations nvOperations;
    ArrayList<NhanVien> nhanViens;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        nvOperations = new NVOperations(this);
        nvOperations.open();

        nhanViens = nvOperations.getAllNhanVien();
        nvOperations.close();
        if (nhanViens != null) {
            Log.i("Nhan Vien", "DSNV co");
            ListView lst = (ListView) findViewById(R.id.lstNV1);
            ArrayList<NhanVien> aa = new ArrayList<NhanVien>();

            for (NhanVien s : nhanViens) {
                Log.i("Nhan Vien", s.toString());
                aa.add(s);

            }
            Log.i("So Nhan Vien", "" + aa.size());
            final CustomAdapterView adapter = new CustomAdapterView(this, R.layout.list_nv_layout, aa);
            lst.setAdapter(adapter);

            lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    NhanVien nhanVien = (NhanVien) adapter.getItem(position);
                    Intent intent = new Intent(ListActivity.this, DKLichLVActivity.class);
                    //truyen doi tuong sang activity moi
                    Bundle bundle = new Bundle();
                    bundle.putInt("id", nhanVien.getMaNV());
                    Log.d("MaNV", nhanVien.getMaNV() + "");
                    bundle.putString("name", nhanVien.getTenNV());
                    bundle.putString("phone", nhanVien.getSdt());
                    bundle.putString("addr", nhanVien.getDiaChi());
                    bundle.putString("email", nhanVien.getEmail());
                    bundle.putString("birth", nhanVien.getNgaySinh());
                    bundle.putString("hireDate", nhanVien.getNgayBD());
                    intent.putExtras(bundle);
                    Log.i("Loi Nhap", nhanVien.getMaNV() + nhanVien.getTenNV() + nhanVien.getSdt() + nhanVien.getDiaChi() + nhanVien.getEmail() + nhanVien.getNgaySinh() + nhanVien.getNgayBD());
                    startActivity(intent);
                }
            });

        }
        else {
            Toast.makeText(ListActivity.this,"Không có nhân viên nào",Toast.LENGTH_LONG ).show();
        }
    }

}

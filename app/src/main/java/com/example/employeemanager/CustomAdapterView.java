package com.example.employeemanager;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.employeemanager.model.NhanVien;

import java.util.ArrayList;

public class CustomAdapterView extends ArrayAdapter<NhanVien> {
    private Context context;
    private int resource;
    private ArrayList<NhanVien> lstScores;//du lieu lk boi adapter la mot mang cac nhan vien

    public CustomAdapterView(Context context, int resource, ArrayList<NhanVien> arr) {
        super(context, resource, arr);
        this.context = context;
        this.resource = resource;
        lstScores = arr;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_nv_layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.txtName);
            viewHolder.tvSdt = (TextView) convertView.findViewById(R.id.txtSDT);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        NhanVien contact = lstScores.get(position);
        Log.i("Nhan Vien", contact.toString());
        viewHolder.tvName.setText(contact.getTenNV());
        viewHolder.tvSdt.setText(contact.getSdt());
        return convertView;
    }

    public class ViewHolder {
        TextView tvName, tvSdt;

    }
}
package com.example.employeemanager.model;

public class NhanVien {
    private int maNV;
    private String tenNV, sdt, email, diaChi, ngaySinh, ngayBD;
    public NhanVien(){}

    public NhanVien(String tenNV, String sdt, String diaChi, String ngaySinh, String ngayBD,String email) {
        this.tenNV = tenNV;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.ngayBD = ngayBD;
    }

    public NhanVien(int maNV, String tenNV, String sdt, String email, String diaChi, String ngaySinh, String ngayBD) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.ngayBD = ngayBD;
    }


    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(String ngayBD) {
        this.ngayBD = ngayBD;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "maNV=" + maNV +
                ", tenNV='" + tenNV + '\'' +
                ", sdt='" + sdt + '\'' +
                ", email='" + email + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", ngayBD='" + ngayBD + '\'' +
                '}';
    }

}

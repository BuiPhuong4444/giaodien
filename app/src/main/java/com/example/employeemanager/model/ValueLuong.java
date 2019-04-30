package com.example.employeemanager.model;

public class ValueLuong {
    private int id_value;
    private String  value;

    public ValueLuong() {
    }

    public ValueLuong(int id_value, String value) {
        this.id_value = id_value;
        this.value = value;
    }

    public ValueLuong(int id_value) {
        this.id_value = id_value;
    }

    public int getId_value() {
        return id_value;
    }

    public void setId_value(int id_value) {
        this.id_value = id_value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ValueLuong{" +
                "id_value=" + id_value +
                ", value=" + value +
                '}';
    }
}

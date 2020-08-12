package com.example.uasakb10117224if7.model;

public class DaftarModel {
//    Tanggal Pengerjaan : 10 08 2020
//    Nim : 10117224
//    Nama : Ahmad Faritz Ied putra
//    Kelas : IF - 7

    private Integer id;
    private String nama;
    private String alamat;
    private String website;

    public DaftarModel(String nama, String website, String alamat) {
//        this.id = nim;
        this.nama = nama;
        this.website = website;
        this.alamat = alamat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

}

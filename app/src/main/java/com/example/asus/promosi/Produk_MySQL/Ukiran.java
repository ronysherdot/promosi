package com.example.asus.promosi.Produk_MySQL;

public class Ukiran {
    int id_produk;
    String nama_produk,gambar,keterangan;
    String deskripsi_singkat;

    public String getDeskripsi_singkat() {
        return deskripsi_singkat;
    }

    public void setDeskripsi_singkat(String deskripsi_singkat) {
        this.deskripsi_singkat = deskripsi_singkat;
    }

    public int getId_produk() {
        return id_produk;
    }

    public void setId_produk(int id_produk) {
        this.id_produk = id_produk;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}

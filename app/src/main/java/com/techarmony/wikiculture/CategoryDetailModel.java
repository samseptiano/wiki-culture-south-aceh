package com.techarmony.wikiculture;

import com.google.gson.annotations.SerializedName;

public class CategoryDetailModel {

    @SerializedName("kebudayaan_id")
    private String kebudayaan_id;
    @SerializedName("kebudayaan_kategori")
    private String kebudayaan_kategori;
    @SerializedName("kebudayaan_nama")
    private String kebudayaan_nama;
    @SerializedName("kebudayaan_foto")
    private String kebudayaan_foto;
    @SerializedName("kebudayaan_desk")
    private String kebudayaan_desk;
    @SerializedName("kebudayaan_status")
    private String kebudayaan_status;
    @SerializedName("kebudayaan_waktu")
    private String kebudayaan_waktu;
    @SerializedName("kategori_nama")
    private String kategori_nama;
    @SerializedName("kebudayaan_input")
    private String kebudayaan_input;

    public String getKebudayaan_input() {
        return kebudayaan_input;
    }

    public void setKebudayaan_input(String kebudayaan_input) {
        this.kebudayaan_input = kebudayaan_input;
    }

    public String getKebudayaan_id() {
        return kebudayaan_id;
    }

    public void setKebudayaan_id(String kebudayaan_id) {
        this.kebudayaan_id = kebudayaan_id;
    }

    public String getKebudayaan_kategori() {
        return kebudayaan_kategori;
    }

    public void setKebudayaan_kategori(String kebudayaan_kategori) {
        this.kebudayaan_kategori = kebudayaan_kategori;
    }

    public String getKebudayaan_nama() {
        return kebudayaan_nama;
    }

    public void setKebudayaan_nama(String kebudayaan_nama) {
        this.kebudayaan_nama = kebudayaan_nama;
    }

    public String getKebudayaan_foto() {
        return kebudayaan_foto;
    }

    public void setKebudayaan_foto(String kebudayaan_foto) {
        this.kebudayaan_foto = kebudayaan_foto;
    }

    public String getKebudayaan_desk() {
        return kebudayaan_desk;
    }

    public void setKebudayaan_desk(String kebudayaan_desk) {
        this.kebudayaan_desk = kebudayaan_desk;
    }

    public String getKebudayaan_status() {
        return kebudayaan_status;
    }

    public void setKebudayaan_status(String kebudayaan_status) {
        this.kebudayaan_status = kebudayaan_status;
    }

    public String getKebudayaan_waktu() {
        return kebudayaan_waktu;
    }

    public void setKebudayaan_waktu(String kebudayaan_waktu) {
        this.kebudayaan_waktu = kebudayaan_waktu;
    }

    public String getKategori_nama() {
        return kategori_nama;
    }

    public void setKategori_nama(String kategori_nama) {
        this.kategori_nama = kategori_nama;
    }



    public CategoryDetailModel() {
    }
}

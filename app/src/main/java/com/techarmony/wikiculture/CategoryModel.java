package com.techarmony.wikiculture;

import com.google.gson.annotations.SerializedName;

public class CategoryModel {
    @SerializedName("kategori_id")
    private String categoryID;

    @SerializedName("kategori_nama")
    private String categoryName;

    @SerializedName("kategori_foto")
    private String kategori_foto;

    public String getKategori_foto() {
        return kategori_foto;
    }

    public void setKategori_foto(String kategori_foto) {
        this.kategori_foto = kategori_foto;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public CategoryModel() {
    }
}

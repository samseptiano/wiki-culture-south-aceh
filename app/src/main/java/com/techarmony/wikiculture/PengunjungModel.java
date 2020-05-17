package com.techarmony.wikiculture;

import com.google.gson.annotations.SerializedName;

public class PengunjungModel {
    @SerializedName("pengunjung_ip")
    private String pengunjung_ip;

    public String getPengunjung_ip() {
        return pengunjung_ip;
    }

    public void setPengunjung_ip(String pengunjung_ip) {
        this.pengunjung_ip = pengunjung_ip;
    }

    public PengunjungModel() {
    }
}

package com.techarmony.wikiculture.ui.aboutme;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.techarmony.wikiculture.API.ApiClient;
import com.techarmony.wikiculture.API.ApiInterface;
import com.techarmony.wikiculture.AboutMeModel;
import com.techarmony.wikiculture.Application.MyApplication;
import com.techarmony.wikiculture.CategoryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AboutmeViewModel extends ViewModel {

    private MutableLiveData<String> author;
    private MutableLiveData<String> desc;
    private MutableLiveData<String> gender;
    private MutableLiveData<String> birthDate;
    private MutableLiveData<String> birthPlace;
    private MutableLiveData<String> prodi;
    private MutableLiveData<String> univ;
    private MutableLiveData<String> agama;
    private MutableLiveData<String> foto;
    private MutableLiveData<String> judul;
    private MutableLiveData<String> alamat;
    private MutableLiveData<String> email;


    Context ctx = MyApplication.getInstance();
    private MutableLiveData<List<AboutMeModel>> showAboutMe;

    public AboutmeViewModel() {
        author = new MutableLiveData<>();
        desc = new MutableLiveData<>();
        gender = new MutableLiveData<>();
        birthDate = new MutableLiveData<>();
        birthPlace = new MutableLiveData<>();
        prodi = new MutableLiveData<>();
        univ = new MutableLiveData<>();
        email = new MutableLiveData<>();
        alamat = new MutableLiveData<>();
        agama = new MutableLiveData<>();
        foto = new MutableLiveData<>();
        judul = new MutableLiveData<>();

        ApiInterface apiService = ApiClient.getClient(ctx).create(ApiInterface.class);
        Call<List<AboutMeModel>> call = apiService.getAboutme();
        call.enqueue(new Callback<List<AboutMeModel>>() {
            @Override
            public void onResponse(Call<List<AboutMeModel>> call, Response<List<AboutMeModel>> response) {
                int statusCode = response.code();
                if(statusCode==200) {
                    author.setValue(response.body().get(0).getPengaturan_author());
                    desc.setValue(response.body().get(0).getPengaturan_tentang());
                    gender.setValue(response.body().get(0).getPengaturan_jk());
                    birthDate.setValue(response.body().get(0).getPengaturan_tanggallahir());
                    birthPlace.setValue(response.body().get(0).getPengaturan_tempatlahir()+", ");
                    prodi.setValue(response.body().get(0).getPengaturan_prodi()+" - "+response.body().get(0).getPengaturan_univ());
                    univ.setValue(response.body().get(0).getPengaturan_prodi()+" - "+response.body().get(0).getPengaturan_univ());
                    agama.setValue(response.body().get(0).getPengaturan_agama());
                    foto.setValue(response.body().get(0).getPengaturan_foto_author());
                    judul.setValue(response.body().get(0).getPengaturan_judul());
                    alamat.setValue(response.body().get(0).getPengaturan_alamat());
                    email.setValue(response.body().get(0).getPengaturan_email());
                }
                else {
                    Toast.makeText(ctx,"Error: "+response.code(),Toast.LENGTH_SHORT).show();
                }
//                pd.dismiss();
            }
            @Override
            public void onFailure(Call<List<AboutMeModel>> call, Throwable t) {
                Toast.makeText(ctx,"Error Connection Found... ",Toast.LENGTH_SHORT).show();
//                pd.dismiss();

            }
        });


    }

    public LiveData<String> getAuthor() {
        return author;
    }
    public LiveData<String> getDesc() {
        return desc;
    }
    public LiveData<String> getGender() {
        return gender;
    }
    public LiveData<String> getBirthdate() {
        return birthDate;
    }
    public LiveData<String> getBirthplace() {
        return birthPlace;
    }
    public LiveData<String> getProdi() {
        return prodi;
    }
    public LiveData<String> getUniv() {
        return univ;
    }
    public LiveData<String> getAgama() {
        return agama;
    }
    public LiveData<String> getFoto() {
        return foto;
    }
    public LiveData<String> getJudul() {
        return judul;
    }
    public LiveData<String> getAlamat() {
        return alamat;
    }
    public LiveData<String> getEmail() {
        return email;
    }


    public LiveData<List<AboutMeModel>> showAboutMe(Context ctx) {

        this.ctx = ctx;
        return showAboutMe;
    }
}
package com.techarmony.wikiculture.API;


import com.techarmony.wikiculture.AboutMeModel;
import com.techarmony.wikiculture.CategoryDetailModel;
import com.techarmony.wikiculture.CategoryModel;
import com.techarmony.wikiculture.PengunjungModel;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;


public interface ApiInterface {

    @GET("data/kategori")
    Call<List<CategoryModel>> getKategori();
    @GET("data/pengaturan")
    Call<List<AboutMeModel>> getAboutme();
    @GET("data/kebudayaan")
    Call<List<CategoryDetailModel>> getKebudayaan(@Query("id") String id);

    @POST("data/pengunjung")
    Call<Void> postPengunjung(@Body PengunjungModel pengunjungModel);
}

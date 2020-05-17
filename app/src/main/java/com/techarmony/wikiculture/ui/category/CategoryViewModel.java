package com.techarmony.wikiculture.ui.category;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.techarmony.wikiculture.API.ApiClient;
import com.techarmony.wikiculture.API.ApiInterface;
import com.techarmony.wikiculture.Application.MyApplication;
import com.techarmony.wikiculture.CategoryModel;
import com.techarmony.wikiculture.MainActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryViewModel extends ViewModel {

    private List<CategoryModel> categoryModelList = new ArrayList<>();
    private MutableLiveData<String> mText;
    private MutableLiveData<List<CategoryModel>> showCategory;

    Context ctx = MyApplication.getInstance();
    ProgressDialog pd;

    public CategoryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is category fragment");


        showCategory = new MutableLiveData<>();

//        pd = new ProgressDialog(MainActivity.getActivity());
//        pd.setMessage("Loading...");
//        pd.setCancelable(false);
//        pd.show();
        ApiInterface apiService = ApiClient.getClient(ctx).create(ApiInterface.class);
        Call<List<CategoryModel>> call = apiService.getKategori();
        call.enqueue(new Callback<List<CategoryModel>>() {
            @Override
            public void onResponse(Call<List<CategoryModel>> call, Response<List<CategoryModel>> response) {
                int statusCode = response.code();
                if(statusCode==200) {
                    showCategory.setValue(response.body());
                }
                else {
                    Toast.makeText(ctx,"Error: "+response.code(),Toast.LENGTH_SHORT).show();
                }
//                pd.dismiss();
            }
            @Override
            public void onFailure(Call<List<CategoryModel>> call, Throwable t) {
                Toast.makeText(ctx,"Error Connection Found... ",Toast.LENGTH_SHORT).show();
//                pd.dismiss();

            }
        });



    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List<CategoryModel>> showCategory(Context ctx) {

        this.ctx = ctx;
        return showCategory;
    }


}
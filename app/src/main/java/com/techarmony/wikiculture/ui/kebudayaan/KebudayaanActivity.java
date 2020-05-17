package com.techarmony.wikiculture.ui.kebudayaan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.techarmony.wikiculture.API.ApiClient;
import com.techarmony.wikiculture.API.ApiInterface;
import com.techarmony.wikiculture.CategoryAdapter;
import com.techarmony.wikiculture.CategoryDetailAdapter;
import com.techarmony.wikiculture.CategoryDetailModel;
import com.techarmony.wikiculture.CategoryModel;
import com.techarmony.wikiculture.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KebudayaanActivity extends AppCompatActivity {

    private CategoryDetailAdapter mAdapter;
    String id="";
    String categoryName="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kebudayaan);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

       // setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        Intent in = getIntent();
        Bundle content = in.getExtras();
        // check null
        if (content != null) {
            id = content.getString("id");
            categoryName = content.getString("categoryName");
        }

        setTitle(categoryName);

        final RecyclerView rvkebudayaan = findViewById(R.id.rvKebudayaan);


        ApiInterface apiService = ApiClient.getClient(getApplicationContext()).create(ApiInterface.class);
        Call<List<CategoryDetailModel>> call = apiService.getKebudayaan(id);
        call.enqueue(new Callback<List<CategoryDetailModel>>() {
            @Override
            public void onResponse(Call<List<CategoryDetailModel>> call, Response<List<CategoryDetailModel>> response) {
                int statusCode = response.code();
                if(statusCode==200) {
                    mAdapter = new CategoryDetailAdapter(response.body(),getApplicationContext());
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    rvkebudayaan.setLayoutManager(mLayoutManager);
                    rvkebudayaan.setItemAnimator(new DefaultItemAnimator());
                    rvkebudayaan.setAdapter(mAdapter);                }
                else {
                    Toast.makeText(getApplicationContext(),"Error: "+response.code(),Toast.LENGTH_SHORT).show();
                }
//                pd.dismiss();
            }
            @Override
            public void onFailure(Call<List<CategoryDetailModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Error Connection Found... ",Toast.LENGTH_SHORT).show();
//                pd.dismiss();

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

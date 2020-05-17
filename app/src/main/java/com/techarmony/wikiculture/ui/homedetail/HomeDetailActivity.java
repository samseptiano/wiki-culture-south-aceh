package com.techarmony.wikiculture.ui.homedetail;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.techarmony.wikiculture.API.ApiClient;
import com.techarmony.wikiculture.API.ApiInterface;
import com.techarmony.wikiculture.CategoryModel;
import com.techarmony.wikiculture.MainActivity;
import com.techarmony.wikiculture.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeDetailActivity extends AppCompatActivity {

    private String kebudayaan_id="";
    private String kebudayaan_kategori="";
    private String kebudayaan_nama="";
    private String kebudayaan_foto="";
    private String kebudayaan_desk="";
    private String kebudayaan_status="";
    private String kebudayaan_waktu="";
    private String kebudayaan_input="";
    private String kategori_nama="";

    ImageView imgDetail;
    TextView tvDesc,tvStatus,tvTime,tvCategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        imgDetail = findViewById(R.id.imgDetail);
        tvDesc = findViewById(R.id.tv_desc);
        tvStatus = findViewById(R.id.tv_status);
        tvTime = findViewById(R.id.tv_time);
        tvCategory = findViewById(R.id.tv_category);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent in = getIntent();
        Bundle content = in.getExtras();
        // check null
        if (content != null) {
            kebudayaan_id = content.getString("kebudayaan_id");
              kebudayaan_kategori=content.getString("kebudayaan_kategori");
              kebudayaan_nama=content.getString("kebudayaan_nama");
              kebudayaan_foto=content.getString("kebudayaan_foto");
              kebudayaan_desk=content.getString("kebudayaan_desk");
              kebudayaan_status=content.getString("kebudayaan_status");
              kebudayaan_waktu=content.getString("kebudayaan_waktu");
              kebudayaan_input=content.getString("kebudayaan_input");
              kategori_nama=content.getString("kategori_nama");
        }
        setTitle(kebudayaan_nama);
        Picasso.with(getApplicationContext()).load(kebudayaan_foto).into(imgDetail);
        tvDesc.setText(kebudayaan_desk);
        tvStatus.setText("Status: "+kebudayaan_status);
        tvTime.setText("Published At: "+kebudayaan_waktu.split(" ")[1].substring(0,5)+" "+kebudayaan_waktu.split(" ")[0]);
        tvCategory.setText("Kategori: "+kategori_nama);


//        ApiInterface apiService = ApiClient.getClient(ctx).create(ApiInterface.class);
//        Call<List<CategoryModel>> call = apiService.getKategori();
//        call.enqueue(new Callback<List<CategoryModel>>() {
//            @Override
//            public void onResponse(Call<List<CategoryModel>> call, Response<List<CategoryModel>> response) {
//                int statusCode = response.code();
//                if(statusCode==200) {
//                    showCategory.setValue(response.body());
//                }
//                else {
//                    Toast.makeText(ctx,"Error: "+response.code(),Toast.LENGTH_SHORT).show();
//                }
//                //pd.dismiss();
//            }
//            @Override
//            public void onFailure(Call<List<CategoryModel>> call, Throwable t) {
//                Toast.makeText(ctx,"Error Connection Found... ",Toast.LENGTH_SHORT).show();
//                //pd.dismiss();
//
//            }
//        });

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
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

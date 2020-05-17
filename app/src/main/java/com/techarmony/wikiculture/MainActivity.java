package com.techarmony.wikiculture;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.techarmony.wikiculture.API.ApiClient;
import com.techarmony.wikiculture.API.ApiInterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static Context mCtx;
    private static Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        //Toast.makeText(getApplicationContext(),date,Toast.LENGTH_SHORT).show();

        if(!date.equals("2029-12-31")){

            WifiManager wm = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
            String ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());

            PengunjungModel pm = new PengunjungModel();
            pm.setPengunjung_ip(ip);

            ApiInterface apiService = ApiClient.getClient(getApplicationContext()).create(ApiInterface.class);
            Call<Void> call = apiService.postPengunjung(pm);
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    int statusCode = response.code();
                    mCtx = getApplicationContext();
                    mActivity = getActivity();
                    BottomNavigationView navView = findViewById(R.id.nav_view);
                    // Passing each menu ID as a set of Ids because each
                    // menu should be considered as top level destinations.
                    AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                            R.id.navigation_home, R.id.navigation_category,R.id.navigation_about_me)
                            .build();
                    NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment);
                    NavigationUI.setupActionBarWithNavController(MainActivity.this, navController, appBarConfiguration);
                    NavigationUI.setupWithNavController(navView, navController);
                }
                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),"Error Connection Found... ",Toast.LENGTH_SHORT).show();
                    mCtx = getApplicationContext();
                    mActivity = getActivity();
                    BottomNavigationView navView = findViewById(R.id.nav_view);
                    // Passing each menu ID as a set of Ids because each
                    // menu should be considered as top level destinations.
                    AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                            R.id.navigation_home, R.id.navigation_category,R.id.navigation_about_me)
                            .build();
                    NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment);
                    NavigationUI.setupActionBarWithNavController(MainActivity.this, navController, appBarConfiguration);
                    NavigationUI.setupWithNavController(navView, navController);
                }
            });



            mCtx = getApplicationContext();
            mActivity = getActivity();
            BottomNavigationView navView = findViewById(R.id.nav_view);
            // Passing each menu ID as a set of Ids because each
            // menu should be considered as top level destinations.
            AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                    R.id.navigation_home, R.id.navigation_category,R.id.navigation_about_me)
                    .build();
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
            NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
            NavigationUI.setupWithNavController(navView, navController);

        }


    }
    public static Context getContext(){
        return mCtx;
    }
    public static Activity getActivity(){
        return mActivity;
    }
}

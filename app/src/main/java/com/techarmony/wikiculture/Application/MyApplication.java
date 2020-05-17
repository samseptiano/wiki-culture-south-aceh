package com.techarmony.wikiculture.Application;

import android.content.Context;

import com.techarmony.wikiculture.NetworkConnection.ConnectivityReceiver;

public class MyApplication extends android.app.Application {
    private static MyApplication mInstance;
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
        mContext = getApplicationContext();

    }

    public static Context getContext(){
        return mContext;
    }

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }



}

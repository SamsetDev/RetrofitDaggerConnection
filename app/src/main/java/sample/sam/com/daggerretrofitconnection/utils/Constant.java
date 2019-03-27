package sample.sam.com.daggerretrofitconnection.utils;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Copyright (C) DaggerRetrofitConnection - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited Proprietary and confidential.
 * <p>
 * Created by samset on 23/03/19 at 2:20 PM for DaggerRetrofitConnection .
 */


public class Constant {

    public static String BASE_URL="";
    public static final String ENDPOINT = "https://api.themoviedb.org/3/";
    public static final String IMAGE_ENDPOINT_PREFIX = "https://image.tmdb.org/t/p/w500/";
    public static final String API_KEY = "";
    public static final int TIMEOUT_IN_SEC = 15;


    public static boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    public String showmsg(){
        return "This massge from Application Scope";
    }
}

package sample.sam.com.daggerretrofitconnection.network.di.module;

import android.app.Application;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sample.sam.com.daggerretrofitconnection.network.ApiServices;
import sample.sam.com.daggerretrofitconnection.utils.Constant;

import static com.google.common.net.HttpHeaders.CACHE_CONTROL;

/**
 * Copyright (C) DaggerRetrofitConnection - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited Proprietary and confidential.
 * <p>
 * Created by samset on 23/03/19 at 2:25 PM for DaggerRetrofitConnection .
 */



@Module //(includes = ViewModelModule.class)
public class AppModule {


    @Provides
    @Singleton
    ApiServices provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(ApiServices.class);
    }

    @Provides
    @Singleton
    Constant getConstants() {
        return new Constant();
    }


    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Application application) {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(Constant.TIMEOUT_IN_SEC, TimeUnit.SECONDS);
        okHttpClient.readTimeout(Constant.TIMEOUT_IN_SEC, TimeUnit.SECONDS);
        okHttpClient.addInterceptor(getIntercepter(application));
        return okHttpClient.build();
    }


    public Interceptor getIntercepter(final Application application) {

        Interceptor headerAuthorizationInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                if (!Constant.isConnected(application)) {
                    Request request = chain.request();
                    CacheControl cacheControl = new CacheControl.Builder().maxStale(1, TimeUnit.DAYS).build();
                    request = request.newBuilder().cacheControl(cacheControl).build();
                    String rawJson = chain.proceed(request).body().string();

                    Log.e("TAG", String.format("req response cache raw JSON response is: %s", rawJson));
                    return chain.proceed(request);
                } else {

                    CacheControl cacheControl = new CacheControl.Builder().maxAge(1, TimeUnit.HOURS).build();
                    Request.Builder request = chain.request().newBuilder();
                    request.addHeader("Accept", "application/json");
                    request.header(CACHE_CONTROL, cacheControl.toString());
                    Response response = chain.proceed(request.build());


                    return response;
                }
            }
        };
        return headerAuthorizationInterceptor;
    }


}

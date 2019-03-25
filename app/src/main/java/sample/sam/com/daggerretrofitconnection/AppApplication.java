package sample.sam.com.daggerretrofitconnection;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import sample.sam.com.daggerretrofitconnection.network.di.AppComponent;
import sample.sam.com.daggerretrofitconnection.network.di.DaggerAppComponent;

/**
 * Copyright (C) DaggerRetrofitConnection - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited Proprietary and confidential.
 * <p>
 * Created by samset on 23/03/19 at 2:24 PM for DaggerRetrofitConnection .
 */


public class AppApplication extends Application implements HasActivityInjector {
    private AppComponent appComponent;
    private static AppApplication appApplication;
    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;



    public static AppApplication getAppApplicationInsatnce() {
        return appApplication == null ? new AppApplication() : appApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder().application(this).build().inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}

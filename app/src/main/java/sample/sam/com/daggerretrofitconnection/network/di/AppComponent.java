package sample.sam.com.daggerretrofitconnection.network.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import sample.sam.com.daggerretrofitconnection.AppApplication;
import sample.sam.com.daggerretrofitconnection.network.di.module.ActivityBuilderModule;
import sample.sam.com.daggerretrofitconnection.network.di.module.AppModule;

/**
 * Copyright (C) DaggerRetrofitConnection - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited Proprietary and confidential.
 * <p>
 * Created by samset on 23/03/19 at 2:09 PM for DaggerRetrofitConnection .
 */


@Singleton
@Component(modules = {AppModule.class,AndroidInjectionModule.class, ActivityBuilderModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(AppApplication aaApp);
}

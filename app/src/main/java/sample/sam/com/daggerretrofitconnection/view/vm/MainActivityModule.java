package sample.sam.com.daggerretrofitconnection.view.vm;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import sample.sam.com.daggerretrofitconnection.utils.Constant;
import sample.sam.com.daggerretrofitconnection.utils.HelloData;

/**
 * Copyright (C) DaggerRetrofitConnection - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited Proprietary and confidential.
 * <p>
 * Created by samset on 23/03/19 at 4:19 PM for DaggerRetrofitConnection .
 */


@Module
public  class MainActivityModule {

    @Provides
    HelloData getHelloData(){
        return new HelloData();
    }

}

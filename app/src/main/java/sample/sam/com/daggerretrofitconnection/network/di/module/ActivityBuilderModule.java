package sample.sam.com.daggerretrofitconnection.network.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import sample.sam.com.daggerretrofitconnection.view.ui.MainActivity;
import sample.sam.com.daggerretrofitconnection.view.vm.MainActivityModule;

/**
 * Copyright (C) DaggerRetrofitConnection - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited Proprietary and confidential.
 * <p>
 * Created by samset on 23/03/19 at 2:25 PM for DaggerRetrofitConnection .
 */





/*
        Create ActivityBuilderModule class which will define bindings for our sub-components so that Dagger can inject them.
        Note that @ContributesAndroidInjector annotation(introduced in 2.11)frees us from having to create separate components annotated with @Subcomponent

*/

@Module
public abstract class ActivityBuilderModule {

    // define all activity module here

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivity();

}

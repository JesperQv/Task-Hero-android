package com.jesperqvarfordt.taskhero.di;

import com.jesperqvarfordt.taskhero.TaskHeroApplication;
import com.jesperqvarfordt.taskhero.domain.api.Retrofit;
import com.jesperqvarfordt.taskhero.domain.api.impl.SharedPrefStorage;
import com.jesperqvarfordt.taskhero.domain.storage.LocalStorage;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private TaskHeroApplication application;

    public AppModule(TaskHeroApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    TaskHeroApplication provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit();
    }

    @Provides
    @Singleton
    LocalStorage provideLocalStorage() {
        return new SharedPrefStorage(application);
    }

}

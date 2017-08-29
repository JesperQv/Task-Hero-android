package com.jesperqvarfordt.taskhero.di;

import com.jesperqvarfordt.taskhero.TaskHeroApplication;
import com.jesperqvarfordt.taskhero.domain.api.Retrofit;

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
    public TaskHeroApplication provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit();
    }
}

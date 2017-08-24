package com.jesperqvarfordt.notely.di;

import com.jesperqvarfordt.notely.NotelyApplication;
import com.jesperqvarfordt.notely.domain.api.Retrofit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private NotelyApplication application;

    public AppModule(NotelyApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public NotelyApplication provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit();
    }
}

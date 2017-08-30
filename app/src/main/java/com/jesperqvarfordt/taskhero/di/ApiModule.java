package com.jesperqvarfordt.taskhero.di;

import com.jesperqvarfordt.taskhero.domain.api.impl.ApiAuthenticationService;
import com.jesperqvarfordt.taskhero.domain.authentication.AuthenticationService;
import com.jesperqvarfordt.taskhero.domain.api.Retrofit;
import com.jesperqvarfordt.taskhero.domain.storage.LocalStorage;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApiModule {

    @Provides
    @Singleton
    public AuthenticationService provideAuthenticationService(Retrofit retrofit, LocalStorage localStorage) {
        return new ApiAuthenticationService(retrofit, localStorage);
    }

}

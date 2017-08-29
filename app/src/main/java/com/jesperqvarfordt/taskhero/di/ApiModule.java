package com.jesperqvarfordt.taskhero.di;

import com.jesperqvarfordt.taskhero.domain.api.impl.ApiAuthenticationService;
import com.jesperqvarfordt.taskhero.domain.authentication.services.AuthenticationService;
import com.jesperqvarfordt.taskhero.domain.api.Retrofit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApiModule {

    @Provides
    @Singleton
    public AuthenticationService provideAuthenticationService(Retrofit retrofit) {
        return new ApiAuthenticationService(retrofit);
    }

}

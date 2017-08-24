package com.jesperqvarfordt.notely.di;

import com.jesperqvarfordt.notely.domain.api.impl.ApiAuthenticationService;
import com.jesperqvarfordt.notely.domain.authentication.services.AuthenticationService;
import com.jesperqvarfordt.notely.domain.api.Retrofit;

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

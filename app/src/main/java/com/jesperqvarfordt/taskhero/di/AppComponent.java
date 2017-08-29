package com.jesperqvarfordt.taskhero.di;

import com.jesperqvarfordt.taskhero.TaskHeroApplication;
import com.jesperqvarfordt.taskhero.domain.api.Retrofit;
import com.jesperqvarfordt.taskhero.domain.authentication.services.AuthenticationService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {

    TaskHeroApplication application();

    Retrofit retrofit();

    AuthenticationService authenticationService();

}

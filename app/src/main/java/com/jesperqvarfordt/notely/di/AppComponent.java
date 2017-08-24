package com.jesperqvarfordt.notely.di;

import com.jesperqvarfordt.notely.NotelyApplication;
import com.jesperqvarfordt.notely.domain.api.Retrofit;
import com.jesperqvarfordt.notely.domain.authentication.services.AuthenticationService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {

    NotelyApplication application();

    Retrofit retrofit();

    AuthenticationService authenticationService();

}

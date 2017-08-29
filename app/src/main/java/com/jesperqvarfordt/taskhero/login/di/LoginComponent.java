package com.jesperqvarfordt.taskhero.login.di;

import com.jesperqvarfordt.taskhero.di.ActivityScope;
import com.jesperqvarfordt.taskhero.di.AppComponent;
import com.jesperqvarfordt.taskhero.login.LoginActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = LoginModule.class)
public interface LoginComponent {

    void inject(LoginActivity view);

}

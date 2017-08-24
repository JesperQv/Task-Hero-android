package com.jesperqvarfordt.notely.login.di;

import com.jesperqvarfordt.notely.di.ActivityScope;
import com.jesperqvarfordt.notely.di.AppComponent;
import com.jesperqvarfordt.notely.login.LoginActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = LoginModule.class)
public interface LoginComponent {

    void inject(LoginActivity view);

}

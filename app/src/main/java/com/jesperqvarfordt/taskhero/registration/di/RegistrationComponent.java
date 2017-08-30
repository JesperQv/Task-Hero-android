package com.jesperqvarfordt.taskhero.registration.di;

import com.jesperqvarfordt.taskhero.di.ActivityScope;
import com.jesperqvarfordt.taskhero.di.AppComponent;
import com.jesperqvarfordt.taskhero.registration.RegistrationActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = RegistrationModule.class)
public interface RegistrationComponent {

    void inject(RegistrationActivity view);

}

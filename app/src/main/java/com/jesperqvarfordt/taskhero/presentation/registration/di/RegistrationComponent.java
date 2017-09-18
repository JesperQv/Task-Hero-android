package com.jesperqvarfordt.taskhero.presentation.registration.di;

import com.jesperqvarfordt.taskhero.di.ActivityScope;
import com.jesperqvarfordt.taskhero.di.AppComponent;
import com.jesperqvarfordt.taskhero.presentation.registration.RegistrationActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = RegistrationModule.class)
public interface RegistrationComponent {

    void inject(RegistrationActivity view);

}

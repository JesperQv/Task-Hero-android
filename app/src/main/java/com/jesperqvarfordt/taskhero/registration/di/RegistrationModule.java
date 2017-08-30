package com.jesperqvarfordt.taskhero.registration.di;

import com.jesperqvarfordt.taskhero.di.ActivityScope;
import com.jesperqvarfordt.taskhero.domain.authentication.AuthenticationService;
import com.jesperqvarfordt.taskhero.registration.RegistrationContract;
import com.jesperqvarfordt.taskhero.registration.RegistrationPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class RegistrationModule {

    private RegistrationContract.View view;

    public RegistrationModule(RegistrationContract.View view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    RegistrationContract.View provideView() {
        return view;
    }

    @Provides
    @ActivityScope
    RegistrationContract.Presenter providePresenter(AuthenticationService service) {
        return new RegistrationPresenter(view, service);
    }
}

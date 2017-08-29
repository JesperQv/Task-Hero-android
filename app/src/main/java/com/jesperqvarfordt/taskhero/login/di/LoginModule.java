package com.jesperqvarfordt.taskhero.login.di;

import com.jesperqvarfordt.taskhero.di.ActivityScope;
import com.jesperqvarfordt.taskhero.domain.authentication.services.AuthenticationService;
import com.jesperqvarfordt.taskhero.login.LoginContract;
import com.jesperqvarfordt.taskhero.login.LoginPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    private LoginContract.View view;

    public LoginModule(LoginContract.View view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    public LoginContract.View provideView() {
        return view;
    }

    @Provides
    @ActivityScope
    public LoginContract.Presenter providePresenter(AuthenticationService service) {
        return new LoginPresenter(view, service);
    }

}

package com.jesperqvarfordt.taskhero.presentation.login.di;

import com.jesperqvarfordt.taskhero.di.ActivityScope;
import com.jesperqvarfordt.taskhero.domain.authentication.AuthenticationService;
import com.jesperqvarfordt.taskhero.presentation.login.LoginContract;
import com.jesperqvarfordt.taskhero.presentation.login.LoginPresenter;

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

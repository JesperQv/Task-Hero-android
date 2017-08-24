package com.jesperqvarfordt.notely.login.di;

import com.jesperqvarfordt.notely.di.ActivityScope;
import com.jesperqvarfordt.notely.domain.authentication.services.AuthenticationService;
import com.jesperqvarfordt.notely.login.LoginContract;
import com.jesperqvarfordt.notely.login.LoginPresenter;

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

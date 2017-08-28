package com.jesperqvarfordt.notely.login;

import android.text.TextUtils;

import com.jesperqvarfordt.notely.domain.authentication.models.LoginResponse;
import com.jesperqvarfordt.notely.domain.authentication.models.User;
import com.jesperqvarfordt.notely.domain.authentication.services.AuthenticationService;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private AuthenticationService authService;
    private CompositeDisposable disposables;

    @Inject
    public LoginPresenter(LoginContract.View view, AuthenticationService authService) {
        this.view = view;
        this.authService = authService;
        disposables = new CompositeDisposable();
    }

    @Override
    public void subscribe() {
        disposables.clear();
    }

    @Override
    public void unsubscribe() {
        disposables.dispose();
    }


    @Override
    public void loginButtonClicked(String username, String password) {
        view.hideKeyboard();
        view.clearErrors();
        if (TextUtils.isEmpty(username)) {
            view.showNoUsernameError();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            view.showNoPasswordError();
            return;
        }

        view.showLoading();
        Disposable disposable = authService.login(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginResponse>() {
                    @Override
                    public void accept(@NonNull LoginResponse response) throws Exception {
                        view.hideLoading();
                        view.showHomeActivity(response.getUser());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        view.hideLoading();
                        view.showWrongCredentialsError();
                    }
                });
        disposables.add(disposable);
    }

    @Override
    public void registerButtonClicked() {
        view.showRegistrationActivity();
    }

}

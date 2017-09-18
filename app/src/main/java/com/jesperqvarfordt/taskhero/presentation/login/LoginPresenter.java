package com.jesperqvarfordt.taskhero.presentation.login;

import android.text.TextUtils;

import com.jesperqvarfordt.taskhero.domain.models.LoginResponse;
import com.jesperqvarfordt.taskhero.domain.authentication.AuthenticationService;

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

    private boolean triedRefresh = false;

    @Inject
    public LoginPresenter(LoginContract.View view,
                          AuthenticationService authService) {
        this.view = view;
        this.authService = authService;
        disposables = new CompositeDisposable();
    }

    @Override
    public void subscribe() {
        disposables.clear();
        if (!triedRefresh) {
            tryRefresh();
        }
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

    @Override
    public void tryRefresh() {
        triedRefresh = true;
        view.showLoading();

        Disposable disposable = authService.refresh()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginResponse>() {
                    @Override
                    public void accept(@NonNull LoginResponse loginResponse) throws Exception {
                        view.showHomeActivity(loginResponse.getUser());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        view.hideLoading();
                    }
                });
        disposables.add(disposable);
    }

}

package com.jesperqvarfordt.taskhero.presentation.registration;

import android.text.TextUtils;

import com.jesperqvarfordt.taskhero.domain.authentication.AuthenticationService;
import com.jesperqvarfordt.taskhero.domain.models.User;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RegistrationPresenter implements RegistrationContract.Presenter {

    private RegistrationContract.View view;
    private AuthenticationService authService;
    private CompositeDisposable disposables;

    @Inject
    public RegistrationPresenter(RegistrationContract.View view,
                                 AuthenticationService authService) {
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
    public void registerButtonClicked(String firstName, String lastName, String email, String username, String password) {
        view.hideKeyboard();
        if (TextUtils.isEmpty(firstName)) {
            view.showFirstNameEmptyError();
            return;
        } else if (TextUtils.isEmpty(lastName)) {
            view.showLastNameEmptyError();
            return;
        } else if (TextUtils.isEmpty(email)) {
            view.showEmailEmptyError();
            return;
        } else if (TextUtils.isEmpty(username)) {
            view.showUsernameEmptyError();
            return;
        } else if (TextUtils.isEmpty(password)) {
            view.showPasswordError();
            return;
        }

        User user = new User(firstName, lastName, email, username, password);

        view.showLoading();
        Disposable disposable = authService.register(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<User>() {
                    @Override
                    public void accept(@NonNull User user) throws Exception {
                        view.hideLoading();
                        view.showSuccess();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        view.hideLoading();
                        view.showUsernameTakenError();
                    }
                });
        disposables.add(disposable);
    }
}

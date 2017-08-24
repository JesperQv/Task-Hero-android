package com.jesperqvarfordt.notely.login;

import com.jesperqvarfordt.notely.domain.authentication.models.User;
import com.jesperqvarfordt.notely.domain.authentication.services.AuthenticationService;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import javax.inject.Inject;
;import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private AuthenticationService authService;

    @Inject
    public LoginPresenter(LoginContract.View view, AuthenticationService authService) {
        this.view = view;
        this.authService = authService;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }


    @Override
    public void loginButtonClicked(String username, String password) {
        authService.login(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull User user) {
                        view.showSuccess(user);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.showError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void registerButtonClicked(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setFirstname("sample");
        user.setLastname("sample");
        user.setEmail("sample@sample.com");

        authService.register(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull User user) {
                view.showRegistered();
            }

            @Override
            public void onError(@NonNull Throwable e) {
                view.showError();
            }

            @Override
            public void onComplete() {

            }
        });
    }
}

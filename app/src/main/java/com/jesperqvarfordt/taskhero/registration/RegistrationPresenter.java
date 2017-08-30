package com.jesperqvarfordt.taskhero.registration;

import com.jesperqvarfordt.taskhero.domain.authentication.AuthenticationService;

import javax.inject.Inject;

public class RegistrationPresenter implements RegistrationContract.Presenter {

    private RegistrationContract.View view;
    private AuthenticationService authService;

    @Inject
    public RegistrationPresenter(RegistrationContract.View view,
                                 AuthenticationService authService) {
        this.view = view;
        this.authService = authService;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}

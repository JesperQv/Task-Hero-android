package com.jesperqvarfordt.taskhero.domain.api.impl;

import com.jesperqvarfordt.taskhero.domain.api.Retrofit;
import com.jesperqvarfordt.taskhero.domain.api.base.ApiService;
import com.jesperqvarfordt.taskhero.domain.authentication.models.LoginRequest;
import com.jesperqvarfordt.taskhero.domain.authentication.models.LoginResponse;
import com.jesperqvarfordt.taskhero.domain.authentication.models.User;
import com.jesperqvarfordt.taskhero.domain.authentication.services.AuthenticationService;

import io.reactivex.Observable;


public class ApiAuthenticationService extends ApiService implements AuthenticationService {

    public ApiAuthenticationService(Retrofit retrofit) {
        super(retrofit);
    }

    @Override
    public Observable<LoginResponse> login(String username, String password) {
        LoginRequest loginRequest = new LoginRequest(username, password);
        return api.login(loginRequest);
    }

    @Override
    public Observable<User> register(User user) {
        return api.register(user);
    }

    @Override
    public void logout() {

    }
}

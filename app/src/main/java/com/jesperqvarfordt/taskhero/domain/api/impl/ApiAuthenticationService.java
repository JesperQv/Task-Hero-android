package com.jesperqvarfordt.taskhero.domain.api.impl;

import com.jesperqvarfordt.taskhero.domain.api.Retrofit;
import com.jesperqvarfordt.taskhero.domain.api.base.ApiService;
import com.jesperqvarfordt.taskhero.domain.authentication.AuthenticationService;
import com.jesperqvarfordt.taskhero.domain.models.LoginRequest;
import com.jesperqvarfordt.taskhero.domain.models.LoginResponse;
import com.jesperqvarfordt.taskhero.domain.models.LogoutRequest;
import com.jesperqvarfordt.taskhero.domain.models.User;
import com.jesperqvarfordt.taskhero.domain.storage.LocalStorage;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;


public class ApiAuthenticationService extends ApiService implements AuthenticationService {

    private LocalStorage localStorage;

    public ApiAuthenticationService(Retrofit retrofit, LocalStorage localStorage) {
        super(retrofit);
        this.localStorage = localStorage;
    }

    @Override
    public Observable<LoginResponse> login(String username, String password) {
        LoginRequest loginRequest = new LoginRequest(username, password);
        return api.login(loginRequest).map(new Function<LoginResponse, LoginResponse>() {
            @Override
            public LoginResponse apply(@NonNull LoginResponse loginResponse) throws Exception {
                localStorage.saveAccessToken(loginResponse.getAccessToken());
                localStorage.saveRefreshToken(loginResponse.getRefreshToken());
                return loginResponse;
            }
        });
    }

    @Override
    public Observable<User> register(User user) {
        return api.register(user);
    }

    @Override
    public void logout() {
        api.logout(new LogoutRequest(localStorage.getRefreshToken()));
    }
}

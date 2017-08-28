package com.jesperqvarfordt.notely.domain.authentication.services;

import com.jesperqvarfordt.notely.domain.authentication.models.LoginResponse;
import com.jesperqvarfordt.notely.domain.authentication.models.User;

import io.reactivex.Observable;


public interface AuthenticationService {

    Observable<LoginResponse> login(String username, String password);

    Observable<User> register(User user);

    void logout();

}

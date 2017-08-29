package com.jesperqvarfordt.taskhero.domain.authentication.services;

import com.jesperqvarfordt.taskhero.domain.authentication.models.LoginResponse;
import com.jesperqvarfordt.taskhero.domain.authentication.models.User;

import io.reactivex.Observable;


public interface AuthenticationService {

    Observable<LoginResponse> login(String username, String password);

    Observable<User> register(User user);

    void logout();

}

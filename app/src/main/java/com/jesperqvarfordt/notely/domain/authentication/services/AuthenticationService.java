package com.jesperqvarfordt.notely.domain.authentication.services;

import com.jesperqvarfordt.notely.domain.authentication.models.User;

import io.reactivex.Observable;


public interface AuthenticationService {

    Observable<User> login(String username, String password);

    Observable<User> register(User user);

    void logout();

}

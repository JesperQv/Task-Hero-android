package com.jesperqvarfordt.taskhero.domain.authentication;

import com.jesperqvarfordt.taskhero.domain.models.LoginResponse;
import com.jesperqvarfordt.taskhero.domain.models.User;

import io.reactivex.Observable;


public interface AuthenticationService {

    Observable<LoginResponse> login(String username, String password);

    Observable<User> register(User user);

    void logout();

}

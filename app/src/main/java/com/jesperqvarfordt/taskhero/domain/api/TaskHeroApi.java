package com.jesperqvarfordt.taskhero.domain.api;

import com.jesperqvarfordt.taskhero.domain.models.LoginRequest;
import com.jesperqvarfordt.taskhero.domain.models.LoginResponse;
import com.jesperqvarfordt.taskhero.domain.models.LogoutRequest;
import com.jesperqvarfordt.taskhero.domain.models.RefreshRequest;
import com.jesperqvarfordt.taskhero.domain.models.User;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface TaskHeroApi {

    @POST("api/authentication/login")
    @Headers({"Content-Type: application/json"})
    Observable<LoginResponse> login(@Body LoginRequest loginRequest);

    @POST("api/authentication/refresh")
    @Headers({"Content-Type: application/json"})
    Observable<LoginResponse> refresh(@Body RefreshRequest refreshRequest);

    @POST("api/authentication/register")
    @Headers({"Content-Type: application/json"})
    Observable<User> register(@Body User user);

    @POST("api/authentication/logout")
    @Headers({"Content-Type: application/json"})
    void logout(@Body LogoutRequest logoutRequest);
}

package com.jesperqvarfordt.notely.domain.api;

import com.jesperqvarfordt.notely.domain.authentication.models.LoginRequest;
import com.jesperqvarfordt.notely.domain.authentication.models.User;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NotelyApi {

    @POST("api/authentication/login")
    @Headers({"Content-Type: application/json"})
    Observable<User> login(@Body LoginRequest loginRequest);

    @POST("api/authentication/register")
    @Headers({"Content-Type: application/json"})
    Observable<User> register(@Body User user);
}

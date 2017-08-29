package com.jesperqvarfordt.taskhero.domain.api;

import com.jesperqvarfordt.taskhero.domain.authentication.models.LoginRequest;
import com.jesperqvarfordt.taskhero.domain.authentication.models.LoginResponse;
import com.jesperqvarfordt.taskhero.domain.authentication.models.User;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NotelyApi {

    @POST("api/authentication/login")
    @Headers({"Content-Type: application/json"})
    Observable<LoginResponse> login(@Body LoginRequest loginRequest);

    @POST("api/authentication/register")
    @Headers({"Content-Type: application/json"})
    Observable<User> register(@Body User user);
}

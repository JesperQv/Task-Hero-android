package com.jesperqvarfordt.taskhero.domain.models;

public class LoginResponse {

    private User user;
    private TokenResponse token;

    public User getUser() {
        return user;
    }

    public String getAccessToken() {
        return token.accessToken;
    }

    public String getRefreshToken() {
        return token.refreshToken;
    }

    private class TokenResponse {

        String accessToken;
        String refreshToken;

    }
}

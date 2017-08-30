package com.jesperqvarfordt.taskhero.domain.models;

public class LogoutRequest {

    private String refreshToken;

    public LogoutRequest(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}

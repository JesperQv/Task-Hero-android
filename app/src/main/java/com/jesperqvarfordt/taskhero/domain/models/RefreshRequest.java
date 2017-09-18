package com.jesperqvarfordt.taskhero.domain.models;

public class RefreshRequest {

    private String refreshToken;

    public RefreshRequest() {}

    public RefreshRequest(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    private String getRefreshToken() {
        return refreshToken;
    }
}

package com.jesperqvarfordt.taskhero.domain.storage;

public interface LocalStorage {

    void saveAccessToken(String accessToken);

    String getAccessToken();

    void saveRefreshToken(String refreshToken);

    String getRefreshToken();

}

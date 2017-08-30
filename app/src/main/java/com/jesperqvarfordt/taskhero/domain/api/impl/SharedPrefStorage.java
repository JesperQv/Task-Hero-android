package com.jesperqvarfordt.taskhero.domain.api.impl;

import android.content.Context;
import android.content.SharedPreferences;

import com.jesperqvarfordt.taskhero.domain.storage.LocalStorage;

public class SharedPrefStorage implements LocalStorage {

    private static final String SHARED_PREFRERENCES = "TaskHeroSharedPreferences";
    private static final String ACCESS_TOKEN = "TaskHeroAccessToken";
    private static final String REFRESH_TOKEN = "TaskHeroRefreshToken";

    private Context context;

    public SharedPrefStorage(Context context) {
        this.context = context;
    }

    private SharedPreferences getSharedPreferences() {
        return context.getSharedPreferences(SHARED_PREFRERENCES, Context.MODE_PRIVATE);
    }

    @Override
    public void saveAccessToken(String accessToken) {
        getSharedPreferences().edit().putString(ACCESS_TOKEN, accessToken).apply();
    }

    @Override
    public String getAccessToken() {
        return getSharedPreferences().getString(ACCESS_TOKEN, "");
    }

    @Override
    public void saveRefreshToken(String refreshToken) {
        getSharedPreferences().edit().putString(REFRESH_TOKEN, refreshToken).apply();
    }

    @Override
    public String getRefreshToken() {
        return getSharedPreferences().getString(REFRESH_TOKEN, "");
    }
}

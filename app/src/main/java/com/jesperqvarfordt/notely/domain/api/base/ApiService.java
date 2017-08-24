package com.jesperqvarfordt.notely.domain.api.base;

import com.jesperqvarfordt.notely.domain.api.NotelyApi;
import com.jesperqvarfordt.notely.domain.api.Retrofit;

public abstract class ApiService {

    protected final NotelyApi api;

    public ApiService(Retrofit retrofit) {
        api = retrofit.getClient();
    }
}

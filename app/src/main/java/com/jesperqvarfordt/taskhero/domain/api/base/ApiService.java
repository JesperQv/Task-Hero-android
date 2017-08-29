package com.jesperqvarfordt.taskhero.domain.api.base;

import com.jesperqvarfordt.taskhero.domain.api.NotelyApi;
import com.jesperqvarfordt.taskhero.domain.api.Retrofit;

public abstract class ApiService {

    protected final NotelyApi api;

    public ApiService(Retrofit retrofit) {
        api = retrofit.getClient();
    }
}

package com.jesperqvarfordt.taskhero.domain.api.base;

import com.jesperqvarfordt.taskhero.domain.api.TaskHeroApi;
import com.jesperqvarfordt.taskhero.domain.api.Retrofit;

public abstract class ApiService {

    protected final TaskHeroApi api;

    public ApiService(Retrofit retrofit) {
        api = retrofit.getClient();
    }
}

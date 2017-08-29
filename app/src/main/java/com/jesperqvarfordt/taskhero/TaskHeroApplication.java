package com.jesperqvarfordt.taskhero;

import android.app.Application;

import com.jesperqvarfordt.taskhero.di.AppComponent;
import com.jesperqvarfordt.taskhero.di.AppModule;
import com.jesperqvarfordt.taskhero.di.DaggerAppComponent;

public class TaskHeroApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}

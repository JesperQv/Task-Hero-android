package com.jesperqvarfordt.notely;

import android.app.Application;

import com.jesperqvarfordt.notely.di.AppComponent;
import com.jesperqvarfordt.notely.di.AppModule;
import com.jesperqvarfordt.notely.di.DaggerAppComponent;

public class NotelyApplication extends Application {

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

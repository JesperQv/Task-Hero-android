package com.jesperqvarfordt.taskhero.base;

import android.app.Activity;

import com.jesperqvarfordt.taskhero.TaskHeroApplication;
import com.jesperqvarfordt.taskhero.di.AppComponent;

public class BaseActivity extends Activity {

    protected TaskHeroApplication getApp() {
        return (TaskHeroApplication) getApplication();
    }

    protected AppComponent getAppComponent() {
        return getApp().getAppComponent();
    }

}

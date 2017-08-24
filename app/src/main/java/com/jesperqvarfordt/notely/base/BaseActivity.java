package com.jesperqvarfordt.notely.base;

import android.app.Activity;

import com.jesperqvarfordt.notely.NotelyApplication;
import com.jesperqvarfordt.notely.di.AppComponent;

public class BaseActivity extends Activity {

    protected NotelyApplication getApp() {
        return (NotelyApplication) getApplication();
    }

    protected AppComponent getAppComponent() {
        return getApp().getAppComponent();
    }

}

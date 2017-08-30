package com.jesperqvarfordt.taskhero.registration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.jesperqvarfordt.taskhero.R;
import com.jesperqvarfordt.taskhero.base.BaseActivity;
import com.jesperqvarfordt.taskhero.registration.di.DaggerRegistrationComponent;
import com.jesperqvarfordt.taskhero.registration.di.RegistrationModule;

import javax.inject.Inject;

public class RegistrationActivity extends BaseActivity implements RegistrationContract.View {

    @Inject
    RegistrationContract.Presenter presenter;

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, RegistrationActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        DaggerRegistrationComponent.builder()
                .appComponent(getAppComponent())
                .registrationModule(new RegistrationModule(this))
                .build()
                .inject(this);

    }
}

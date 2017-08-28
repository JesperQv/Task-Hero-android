package com.jesperqvarfordt.notely.registration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.jesperqvarfordt.notely.R;
import com.jesperqvarfordt.notely.base.BaseActivity;

public class RegistrationActivity extends BaseActivity {

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, RegistrationActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }
}

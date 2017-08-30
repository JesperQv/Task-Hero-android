package com.jesperqvarfordt.taskhero.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.jesperqvarfordt.taskhero.R;
import com.jesperqvarfordt.taskhero.base.BaseActivity;
import com.jesperqvarfordt.taskhero.domain.models.User;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {

    private static final String ARG_USER = "userArgument";

    @BindView(R.id.tv)
    TextView tv;

    public static void show(@NonNull Activity activity, @NonNull User user) {
        Intent intent = new Intent(activity, HomeActivity.class);
        intent.putExtra(ARG_USER, user);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        User user = getIntent().getParcelableExtra(ARG_USER);
        tv.setText(user.getFullName());
    }
}

package com.jesperqvarfordt.notely.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jesperqvarfordt.notely.R;
import com.jesperqvarfordt.notely.base.BaseActivity;
import com.jesperqvarfordt.notely.domain.authentication.models.User;
import com.jesperqvarfordt.notely.login.di.DaggerLoginComponent;
import com.jesperqvarfordt.notely.login.di.LoginModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @BindView(R.id.username) EditText username;
    @BindView(R.id.password) EditText password;
    @BindView(R.id.login_button) Button loginButton;
    @BindView(R.id.register_button) Button registerButton;
    @BindView(R.id.result) TextView result;

    @Inject
    LoginContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        DaggerLoginComponent.builder()
                .appComponent(getAppComponent())
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loginButtonClicked(
                        username.getText().toString().trim(),
                        password.getText().toString());
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.registerButtonClicked(
                        username.getText().toString().trim(),
                        password.getText().toString()
                );
            }
        });

    }

    @Override
    public void showSuccess(User user) {
        result.setText(user.toString());
    }

    @Override
    public void showRegistered() {
        result.setText("Register success");
    }

    @Override
    public void showError() {
        result.setText("Error");
    }
}

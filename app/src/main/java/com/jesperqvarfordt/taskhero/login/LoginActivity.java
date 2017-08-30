package com.jesperqvarfordt.taskhero.login;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.jesperqvarfordt.taskhero.R;
import com.jesperqvarfordt.taskhero.base.BaseActivity;
import com.jesperqvarfordt.taskhero.domain.models.User;
import com.jesperqvarfordt.taskhero.home.HomeActivity;
import com.jesperqvarfordt.taskhero.login.di.DaggerLoginComponent;
import com.jesperqvarfordt.taskhero.login.di.LoginModule;
import com.jesperqvarfordt.taskhero.registration.RegistrationActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @BindView(R.id.username_edittext)
    TextInputEditText username;
    @BindView(R.id.password_edittext)
    TextInputEditText password;
    @BindView(R.id.content_container)
    View contentContainer;
    @BindView(R.id.loading_container)
    View loadingContainer;

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

    }

    @OnClick(R.id.login_button)
    public void login() {
        presenter.loginButtonClicked(
                username.getText().toString().trim(),
                password.getText().toString());
    }

    @OnClick(R.id.registration_button)
    public void register() {
        presenter.registerButtonClicked();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.subscribe();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unsubscribe();
    }

    @Override
    public void showLoading() {
        contentContainer.setVisibility(View.GONE);
        loadingContainer.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loadingContainer.setVisibility(View.GONE);
        contentContainer.setVisibility(View.VISIBLE);
    }

    @Override
    public void showHomeActivity(User user) {
        HomeActivity.show(this, user);
        finish();
    }

    @Override
    public void showRegistrationActivity() {
        RegistrationActivity.show(this);
    }

    @Override
    public void showWrongCredentialsError() {
        password.requestFocus();
        password.setError("Wrong username or password");
    }

    @Override
    public void showNoUsernameError() {
        username.requestFocus();
        username.setError("Enter a username");
    }

    @Override
    public void showNoPasswordError() {
        password.requestFocus();
        password.setError("Enter a password");
    }

    @Override
    public void clearErrors() {
        username.setError(null);
        password.setError(null);
    }

    @Override
    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        if(getCurrentFocus() != null)
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }


}

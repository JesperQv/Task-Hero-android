package com.jesperqvarfordt.taskhero.presentation.registration;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.jesperqvarfordt.taskhero.R;
import com.jesperqvarfordt.taskhero.presentation.base.BaseActivity;
import com.jesperqvarfordt.taskhero.presentation.registration.di.DaggerRegistrationComponent;
import com.jesperqvarfordt.taskhero.presentation.registration.di.RegistrationModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistrationActivity extends BaseActivity implements RegistrationContract.View {

    @BindView(R.id.first_name_edit_text)
    EditText firstName;
    @BindView(R.id.last_name_edit_text)
    EditText lastName;
    @BindView(R.id.email_edit_text)
    EditText email;
    @BindView(R.id.username_edit_text)
    EditText username;
    @BindView(R.id.password_edit_text)
    EditText password;
    @BindView(R.id.content_container)
    View contentContainer;
    @BindView(R.id.loading_container)
    View loadingContainer;
    @BindView(R.id.success)
    TextView success;

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
        ButterKnife.bind(this);

        DaggerRegistrationComponent.builder()
                .appComponent(getAppComponent())
                .registrationModule(new RegistrationModule(this))
                .build()
                .inject(this);

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

    @OnClick(R.id.register_button)
    public void register() {
        presenter.registerButtonClicked(firstName.getText().toString(),
                lastName.getText().toString(),
                email.getText().toString(),
                username.getText().toString(),
                password.getText().toString());
    }


    @Override
    public void showLoading() {
        loadingContainer.setVisibility(View.VISIBLE);
        contentContainer.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        contentContainer.setVisibility(View.VISIBLE);
        loadingContainer.setVisibility(View.GONE);
    }

    @Override
    public void showFirstNameEmptyError() {
        firstName.requestFocus();
        firstName.setError("Enter your first name");
    }

    @Override
    public void showLastNameEmptyError() {
        lastName.requestFocus();
        lastName.setError("Enter your last name");
    }

    @Override
    public void showEmailEmptyError() {
        email.requestFocus();
        email.setError("Enter your email");
    }

    @Override
    public void showUsernameTakenError() {
        username.requestFocus();
        username.setError("Username is already in use");
    }

    @Override
    public void showUsernameEmptyError() {
        username.requestFocus();
        username.setError("Enter a username");
    }

    @Override
    public void showPasswordError() {
        password.requestFocus();
        password.setError("Enter a password");
    }

    @Override
    public void showSuccess() {
        success.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        if(getCurrentFocus() != null)
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
}

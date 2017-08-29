package com.jesperqvarfordt.taskhero.login;

import com.jesperqvarfordt.taskhero.base.BasePresenter;
import com.jesperqvarfordt.taskhero.base.BaseView;
import com.jesperqvarfordt.taskhero.domain.authentication.models.User;

public interface LoginContract {

    interface View extends BaseView<Presenter> {

        void showLoading();

        void hideLoading();

        void showHomeActivity(User user);

        void showRegistrationActivity();

        void showWrongCredentialsError();

        void showNoUsernameError();

        void showNoPasswordError();

        void clearErrors();

        void hideKeyboard();

    }

    interface Presenter extends BasePresenter {

        void loginButtonClicked(String username, String password);

        void registerButtonClicked();

    }
}

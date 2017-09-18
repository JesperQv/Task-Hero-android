package com.jesperqvarfordt.taskhero.presentation.login;

import com.jesperqvarfordt.taskhero.presentation.base.BasePresenter;
import com.jesperqvarfordt.taskhero.presentation.base.BaseView;
import com.jesperqvarfordt.taskhero.domain.models.User;

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

        void tryRefresh();

    }
}

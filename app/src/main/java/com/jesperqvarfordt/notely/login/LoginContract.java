package com.jesperqvarfordt.notely.login;

import com.jesperqvarfordt.notely.base.BasePresenter;
import com.jesperqvarfordt.notely.base.BaseView;
import com.jesperqvarfordt.notely.domain.authentication.models.User;

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

package com.jesperqvarfordt.notely.login;

import com.jesperqvarfordt.notely.base.BasePresenter;
import com.jesperqvarfordt.notely.base.BaseView;
import com.jesperqvarfordt.notely.domain.authentication.models.User;

public interface LoginContract {

    interface View extends BaseView<Presenter> {

        void showSuccess(User user);

        void showRegistered();

        void showError();

    }

    interface Presenter extends BasePresenter {

        void loginButtonClicked(String username, String password);

        void registerButtonClicked(String username, String password);

    }
}

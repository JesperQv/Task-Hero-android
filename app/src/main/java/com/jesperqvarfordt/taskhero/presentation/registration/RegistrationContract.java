package com.jesperqvarfordt.taskhero.presentation.registration;

import com.jesperqvarfordt.taskhero.presentation.base.BasePresenter;
import com.jesperqvarfordt.taskhero.presentation.base.BaseView;

public interface RegistrationContract {

    interface View extends BaseView<Presenter> {

        void showLoading();

        void hideLoading();

        void showFirstNameEmptyError();

        void showLastNameEmptyError();

        void showEmailEmptyError();

        void showUsernameTakenError();

        void showUsernameEmptyError();

        void showPasswordError();

        void showSuccess();

        void hideKeyboard();

    }

    interface Presenter extends BasePresenter {

        void registerButtonClicked(String firstName, String lastName, String email,
                                   String username, String password);

    }

}

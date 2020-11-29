package org.olebas.chat.ui.signup

import org.olebas.chat.data.local.AppPreferences
import org.olebas.chat.ui.auth.AuthInteractor

class SignUpPresenterImpl(private val view: SignUpView) : SignUpPresenter,
        AuthInteractor.OnAuthFinishedListener, SignUpInteractor.OnSignUpFinishedListener {

    private val interactor: SignUpInteractor = SignUpInteractorImpl()
    override var preferences: AppPreferences = AppPreferences.create(view.getContext())

    override fun onSuccess() {
        interactor.getAuthorisation(this)
    }

    override fun onError() {
        view.hideProgress()
        view.showSignUpError()
    }

    override fun onUsernameError() {
        view.hideProgress()
        view.setUsernameError()
    }

    override fun onPasswordError() {
        view.hideProgress()
        view.setPasswordError()
    }

    override fun onPhoneNumberError() {
        view.hideProgress()
        view.setPhoneNumberError()
    }

    override fun executeSignUp(username: String, phoneNumber: String, password: String) {
        view.showProgress()
        interactor.signUp(username, phoneNumber, password, this)
    }

    override fun onAuthError() {
        view.hideProgress()
        view.showAuthError()
    }

    override fun onAuthSuccess() {
        interactor.persistAccessToken(preferences)
        interactor.persistUserDetails(preferences)
        view.hideProgress()
        view.navigateToHome()
    }

}
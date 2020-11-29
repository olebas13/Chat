package org.olebas.chat.ui.signup

import org.olebas.chat.ui.auth.AuthView
import org.olebas.chat.ui.base.BaseView

interface SignUpView : BaseView, AuthView {

    fun showProgress()

    fun showSignUpError()

    fun hideProgress()

    fun setUsernameError()

    fun setPhoneNumberError()

    fun setPasswordError()

    fun navigateToHome()

}
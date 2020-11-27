package org.olebas.chat.ui.login

import org.olebas.chat.ui.auth.AuthView
import org.olebas.chat.ui.base.BaseView

interface LoginView : BaseView, AuthView {

    fun showProgress()

    fun hideProgress()

    fun setUsernameError()

    fun setPasswordError()

    fun navigateToSignUp()

    fun navigateToHome()

}
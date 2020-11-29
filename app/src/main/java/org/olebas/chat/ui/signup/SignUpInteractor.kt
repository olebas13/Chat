package org.olebas.chat.ui.signup

import org.olebas.chat.ui.auth.AuthInteractor

interface SignUpInteractor : AuthInteractor {

    interface OnSignUpFinishedListener {
        fun onSuccess()

        fun onUsernameError()

        fun onPasswordError()

        fun onPhoneNumberError()

        fun onError()
    }

    fun signUp(username: String, phoneNumber: String, password: String,
               listener: OnSignUpFinishedListener)

    fun getAuthorisation(listener: AuthInteractor.OnAuthFinishedListener)

}
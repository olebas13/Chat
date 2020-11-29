package org.olebas.chat.ui.signup

import org.olebas.chat.data.local.AppPreferences

interface SignUpPresenter {

    var preferences: AppPreferences

    fun executeSignUp(username: String, phoneNumber: String, password: String)

}
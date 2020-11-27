package org.olebas.chat.ui.auth

import org.olebas.chat.data.local.AppPreferences
import org.olebas.chat.data.vo.UserVO

interface AuthInteractor {

    var userDetails: UserVO
    var accessToken: String
    var submittedUsername: String
    var submittedPassword: String

    interface OnAuthFinishedListener {

        fun onAuthSuccess()

        fun onAuthError()

        fun onUsernameError()

        fun onPasswordError()

    }

    fun persistAccessToken(preferences: AppPreferences)

    fun persistUserDetails(preferences: AppPreferences)
}
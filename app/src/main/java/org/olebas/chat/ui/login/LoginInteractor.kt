package org.olebas.chat.ui.login

import org.olebas.chat.data.local.AppPreferences
import org.olebas.chat.ui.auth.AuthInteractor

interface LoginInteractor : AuthInteractor {

    interface OnDetailsRetrievalFinishedListener {
        fun onDetailsRetrievalSuccess()

        fun onDetailsRetrievalError()
    }

    fun login(username: String, password: String, listener: AuthInteractor.OnAuthFinishedListener)

    fun retrieveDetails(preferences: AppPreferences, listener: OnDetailsRetrievalFinishedListener)
}
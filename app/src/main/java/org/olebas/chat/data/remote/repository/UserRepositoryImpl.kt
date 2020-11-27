package org.olebas.chat.data.remote.repository

import android.content.Context
import io.reactivex.Observable
import org.olebas.chat.data.local.AppPreferences
import org.olebas.chat.data.vo.UserListVO
import org.olebas.chat.data.vo.UserVO
import org.olebas.chat.service.MessengerApiService

class UserRepositoryImpl(ctx: Context) : UserRepository {

    private val preferences: AppPreferences = AppPreferences.create(ctx)
    private val service: MessengerApiService = MessengerApiService.getInstance()

    override fun findById(id: Long): Observable<UserVO> {
        return service.showUser(id, preferences.accessToken as String)
    }

    override fun all(): Observable<UserListVO> {
        return service.listUsers(preferences.accessToken as String)
    }

    override fun echoDetails(): Observable<UserVO> {
        return service.echoDetails(preferences.accessToken as String)
    }

}
package org.olebas.chat.data.remote.repository

import io.reactivex.Observable
import org.olebas.chat.data.vo.UserListVO
import org.olebas.chat.data.vo.UserVO

interface UserRepository {

    fun findById(id: Long): Observable<UserVO>

    fun all(): Observable<UserListVO>

    fun echoDetails(): Observable<UserVO>

}
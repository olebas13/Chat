package org.olebas.chat.data.remote.repository

import android.content.Context
import io.reactivex.Observable
import org.olebas.chat.data.local.AppPreferences
import org.olebas.chat.data.vo.ConversationListVO
import org.olebas.chat.data.vo.ConversationVO
import org.olebas.chat.service.MessengerApiService

class ConversationRepositoryImpl(ctx: Context) : ConversationRepository {

    private val preferences: AppPreferences = AppPreferences.create(ctx)
    private val service: MessengerApiService = MessengerApiService.getInstance()

    override fun findConversationById(id: Long): Observable<ConversationVO> {
        return service.showConversation(id, preferences.accessToken as String)
    }

    override fun all(): Observable<ConversationListVO> {
        return service.listConversations(preferences.accessToken as String)
    }

}
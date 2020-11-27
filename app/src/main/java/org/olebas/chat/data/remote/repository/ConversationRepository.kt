package org.olebas.chat.data.remote.repository

import io.reactivex.Observable
import org.olebas.chat.data.vo.ConversationListVO
import org.olebas.chat.data.vo.ConversationVO

interface ConversationRepository {

    fun findConversationById(id: Long): Observable<ConversationVO>

    fun all(): Observable<ConversationListVO>

}
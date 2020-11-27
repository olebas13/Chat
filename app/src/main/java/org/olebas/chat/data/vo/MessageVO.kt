package org.olebas.chat.data.vo

data class MessageVO(
        val id: Long,
        val senderId: Long,
        val recipientId: Long,
        val conversationId: Long,
        val body: String,
        val createdAt: String
)

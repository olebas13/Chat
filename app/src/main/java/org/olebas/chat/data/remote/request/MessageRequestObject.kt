package org.olebas.chat.data.remote.request

data class MessageRequestObject(
    val recipientId: Long,
    val message: String
)

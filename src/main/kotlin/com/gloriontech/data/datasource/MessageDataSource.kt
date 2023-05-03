package com.gloriontech.data.datasource

import com.gloriontech.data.model.Message

interface MessageDataSource {

    suspend fun insertMessage(message: Message)

    suspend fun getAllMessages(): List<Message>
}
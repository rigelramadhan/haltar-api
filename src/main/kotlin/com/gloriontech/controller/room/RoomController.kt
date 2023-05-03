package com.gloriontech.controller.room

import com.gloriontech.data.datasource.MessageDataSource
import com.gloriontech.data.model.Message
import io.ktor.websocket.*
import java.util.concurrent.ConcurrentHashMap

class RoomController(
    private val messageDataSource: MessageDataSource
) {

    private val members = ConcurrentHashMap<String, Member>()

    fun onJoin(
        username: String,
        sessionId: String,
        socket: WebSocketSession,
    ) {
        if (members.containsKey(username)) {
            throw MemberAlreadyExistsException()
        }

        members[username] = Member(
            username, sessionId, socket
        )
    }

    suspend fun sendMessage(username: String, message: String) {
        members.values.forEach { member ->
            val data = Message(
                text = message,
                userId = username,
                timestamp = System.currentTimeMillis()
            )

            messageDataSource.insertMessage(data)
        }
    }

}
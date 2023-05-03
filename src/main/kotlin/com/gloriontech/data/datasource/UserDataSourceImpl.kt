package com.gloriontech.data.datasource

import com.gloriontech.data.model.User
import org.litote.kmongo.coroutine.CoroutineDatabase

class UserDataSourceImpl(
    private val db: CoroutineDatabase
) : UserDataSource {

    private val users = db.getCollection<User>()

    override suspend fun insertUser(user: User) {
        users.insertOne(user)
    }

    override suspend fun getUserById(id: String): User? {
        return users.findOneById(id)
    }

    override suspend fun getAllUsers(): List<User> {
        return users.find()
            .toList()
    }
}
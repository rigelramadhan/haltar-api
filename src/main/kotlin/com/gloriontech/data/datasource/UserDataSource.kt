package com.gloriontech.data.datasource

import com.gloriontech.data.model.User

interface UserDataSource {

    suspend fun insertUser(user: User)

    suspend fun getUserById(id: String): User?

    suspend fun getAllUsers(): List<User>
}
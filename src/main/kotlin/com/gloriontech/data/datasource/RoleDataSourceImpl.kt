package com.gloriontech.data.datasource

import com.gloriontech.data.model.Role
import org.litote.kmongo.coroutine.CoroutineDatabase

class RoleDataSourceImpl(
    private val db: CoroutineDatabase
) : RoleDataSource {

    private val roles = db.getCollection<Role>()

    override suspend fun insertRole(role: Role) {
        roles.insertOne(role)
    }

    override suspend fun getAllRoles(): List<Role> {
        return roles.find()
            .toList()
    }
}
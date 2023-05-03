package com.gloriontech.data.datasource

import com.gloriontech.data.model.Role

interface RoleDataSource {

    suspend fun insertRole(role: Role)

    suspend fun getAllRoles(): List<Role>
}
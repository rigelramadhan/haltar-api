package com.gloriontech.data.model

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class Role(
    @BsonId
    val id: String = ObjectId().toString(),

    val name: String,
    val level: Int,
    val dateCreated: Long,
    val dateModified: Long,
)

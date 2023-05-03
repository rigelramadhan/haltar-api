package com.gloriontech.controller.room

class MemberAlreadyExistsException : Exception("A member with the same username already exists in the room") {
}
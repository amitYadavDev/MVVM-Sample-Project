package io.parkplus.sampleprojectmvvm.data.model

import io.parkplus.sampleprojectmvvm.domain.model.User

data class UserDto(
    val id: Int,
    val name: String,
    val email: String
) {
    fun toDomain() = User(id, name, email)
}

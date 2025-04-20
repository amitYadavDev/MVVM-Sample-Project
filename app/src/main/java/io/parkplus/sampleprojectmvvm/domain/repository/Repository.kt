package io.parkplus.sampleprojectmvvm.domain.repository

import io.parkplus.sampleprojectmvvm.domain.model.User

interface Repository {
    suspend fun getUsers(): List<User>
}
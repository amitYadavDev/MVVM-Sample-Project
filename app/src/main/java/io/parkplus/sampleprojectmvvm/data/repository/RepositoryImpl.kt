package io.parkplus.sampleprojectmvvm.data.repository

import io.parkplus.sampleprojectmvvm.data.remote.ApiService
import io.parkplus.sampleprojectmvvm.domain.model.User
import io.parkplus.sampleprojectmvvm.domain.repository.Repository

class RepositoryImpl(private val api: ApiService): Repository {
    override suspend fun getUsers(): List<User> {
        return api.getUsers().map { it.toDomain() }
    }
}
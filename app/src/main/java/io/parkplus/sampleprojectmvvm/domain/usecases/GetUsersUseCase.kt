package io.parkplus.sampleprojectmvvm.domain.usecases

import io.parkplus.sampleprojectmvvm.domain.model.User
import io.parkplus.sampleprojectmvvm.domain.repository.Repository

class GetUsersUseCase(private val repository: Repository) {
    suspend operator fun invoke(): List<User> {
        return repository.getUsers()
    }
}
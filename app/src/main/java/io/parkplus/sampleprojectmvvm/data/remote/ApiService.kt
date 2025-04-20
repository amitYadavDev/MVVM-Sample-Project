package io.parkplus.sampleprojectmvvm.data.remote

import io.parkplus.sampleprojectmvvm.data.model.UserDto
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<UserDto>

}
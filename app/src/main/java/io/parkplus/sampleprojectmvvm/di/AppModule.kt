package io.parkplus.sampleprojectmvvm.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.parkplus.sampleprojectmvvm.data.remote.ApiService
import io.parkplus.sampleprojectmvvm.data.repository.RepositoryImpl
import io.parkplus.sampleprojectmvvm.domain.repository.Repository
import io.parkplus.sampleprojectmvvm.domain.usecases.GetUsersUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    fun provideApi(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideUserRepository(apiService: ApiService): Repository {
        return RepositoryImpl(apiService)
    }

    @Provides
    fun provideUserUseCase(repository: Repository): GetUsersUseCase {
        return GetUsersUseCase(repository)
    }
}
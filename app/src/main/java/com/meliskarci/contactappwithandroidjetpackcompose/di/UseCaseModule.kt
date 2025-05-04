package com.meliskarci.contactappwithandroidjetpackcompose.di

import com.meliskarci.contactappwithandroidjetpackcompose.domain.repository.ContactDaoRepositoryImpl
import com.meliskarci.contactappwithandroidjetpackcompose.domain.usecase.DeleteContactByIdUseCase
import com.meliskarci.contactappwithandroidjetpackcompose.domain.usecase.GetAllContactsUseCase
import com.meliskarci.contactappwithandroidjetpackcompose.domain.usecase.GetContactByIdUseCase
import com.meliskarci.contactappwithandroidjetpackcompose.domain.usecase.InsertContactUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideInsertContactUseCase(repository: ContactDaoRepositoryImpl) : InsertContactUseCase {
        return InsertContactUseCase(repository)/////neyi provide ediyorsam onu aynı şekilde dışarı çıkarmam gerek ve benden repository istiyor repositoryimpl
    }

    @Provides
    @Singleton
    fun provideGetAllContactsUseCase(repositoryImpl: ContactDaoRepositoryImpl) : GetAllContactsUseCase {
        return GetAllContactsUseCase(repositoryImpl)
    }

    @Provides
    @Singleton
    fun provideDeleteContactByIdUseCase(repository: ContactDaoRepositoryImpl) : DeleteContactByIdUseCase {
        return DeleteContactByIdUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetContactByIdUseCase(repositoryImpl: ContactDaoRepositoryImpl) : GetContactByIdUseCase {
        return GetContactByIdUseCase(repositoryImpl)

    }
}
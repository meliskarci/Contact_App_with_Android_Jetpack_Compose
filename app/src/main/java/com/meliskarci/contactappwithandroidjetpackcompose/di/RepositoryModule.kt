package com.meliskarci.contactappwithandroidjetpackcompose.di

import com.meliskarci.contactappwithandroidjetpackcompose.data.local.ContactDao
import com.meliskarci.contactappwithandroidjetpackcompose.domain.repository.ContactDaoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideContactDaoRepositoryImpl(contactDao: ContactDao): ContactDaoRepositoryImpl {
        return ContactDaoRepositoryImpl(contactDao)
    }
}
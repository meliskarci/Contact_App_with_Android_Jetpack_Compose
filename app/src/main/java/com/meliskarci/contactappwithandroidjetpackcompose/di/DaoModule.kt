package com.meliskarci.contactappwithandroidjetpackcompose.di

import com.meliskarci.contactappwithandroidjetpackcompose.data.local.ContactDao
import com.meliskarci.contactappwithandroidjetpackcompose.data.local.ContactDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    @Singleton
    fun provideContactDao(database: ContactDatabase): ContactDao {
        return database.contactDao()
    }
}
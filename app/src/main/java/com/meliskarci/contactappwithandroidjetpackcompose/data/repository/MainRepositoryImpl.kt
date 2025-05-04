package com.meliskarci.contactappwithandroidjetpackcompose.data.repository

import com.meliskarci.contactappwithandroidjetpackcompose.data.local.MainDao
import com.meliskarci.contactappwithandroidjetpackcompose.domain.repository.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainDao: MainDao,
) : MainRepository
package com.meliskarci.contactappwithandroidjetpackcompose.domain.usecase

import com.meliskarci.contactappwithandroidjetpackcompose.data.local.ContactEntity
import com.meliskarci.contactappwithandroidjetpackcompose.domain.repository.ContactDaoRepositoryImpl
import javax.inject.Inject

class InsertContactUseCase @Inject constructor(
    private val repository: ContactDaoRepositoryImpl
){
    suspend operator fun invoke(contactEntity: ContactEntity) {
        repository.insertContact(contactEntity)
    }
}
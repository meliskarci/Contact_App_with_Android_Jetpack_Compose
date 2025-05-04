package com.meliskarci.contactappwithandroidjetpackcompose.domain.usecase

import com.meliskarci.contactappwithandroidjetpackcompose.data.local.ContactEntity
import com.meliskarci.contactappwithandroidjetpackcompose.domain.repository.ContactDaoRepositoryImpl
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetContactByIdUseCase @Inject constructor(
    private val repository: ContactDaoRepositoryImpl
) {
    operator fun invoke(id: Int) : Flow<ContactEntity> {
        return repository.getContactById(id)
    }
}
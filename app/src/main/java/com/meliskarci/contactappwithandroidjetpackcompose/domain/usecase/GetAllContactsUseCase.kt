package com.meliskarci.contactappwithandroidjetpackcompose.domain.usecase

import com.meliskarci.contactappwithandroidjetpackcompose.data.local.ContactEntity
import com.meliskarci.contactappwithandroidjetpackcompose.domain.repository.ContactDaoRepositoryImpl
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllContactsUseCase @Inject constructor(
    private val repositoryImpl: ContactDaoRepositoryImpl
) {
    operator fun invoke() : Flow<List<ContactEntity>> {
        return repositoryImpl.getAllContacts()
    }

}
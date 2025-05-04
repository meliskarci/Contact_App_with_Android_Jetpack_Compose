package com.meliskarci.contactappwithandroidjetpackcompose.domain.usecase

import com.meliskarci.contactappwithandroidjetpackcompose.domain.repository.ContactDaoRepositoryImpl
import javax.inject.Inject

class DeleteContactByIdUseCase @Inject constructor(
    private val repository: ContactDaoRepositoryImpl
) {
    suspend operator fun invoke(id: Int) {
        repository.deleteContactById(id = id)
    }
}
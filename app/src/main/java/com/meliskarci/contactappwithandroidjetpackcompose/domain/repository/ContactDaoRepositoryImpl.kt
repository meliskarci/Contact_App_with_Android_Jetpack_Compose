package com.meliskarci.contactappwithandroidjetpackcompose.domain.repository

import com.meliskarci.contactappwithandroidjetpackcompose.data.local.ContactDao
import com.meliskarci.contactappwithandroidjetpackcompose.data.local.ContactEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ContactDaoRepositoryImpl @Inject constructor(
    private val contactDao: ContactDao
) {
    suspend fun insertContact(contactEntity: ContactEntity) {
        contactDao.insertContact(contactEntity)
    }

    fun getAllContacts() : Flow<List<ContactEntity>> = flow {
        val contacts = contactDao.getAllContacts()
        contacts.collect { value ->
            emit(value)
        }
    }

    fun getContactById(id : Int) : Flow<ContactEntity> = flow {
        contactDao.getContactById(id).collect { value ->
            emit(value)
        }
    }

    suspend fun deleteContactById(id : Int) {
        contactDao.deleteContactById(id = id)
    }

}
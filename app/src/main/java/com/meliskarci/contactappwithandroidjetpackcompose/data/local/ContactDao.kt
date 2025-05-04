package com.meliskarci.contactappwithandroidjetpackcompose.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    @Insert
    suspend fun insertContact(contactEntity: ContactEntity)

    @Query("SELECT * FROM Contacts") //ORDER BY id DESC
    fun getAllContacts(): Flow<List<ContactEntity>>

    @Query("SELECT * FROM contacts WHERE id = :id")
    fun getContactById(id: Int): Flow<ContactEntity>

    @Query("DELETE FROM Contacts WHERE id = :id")
    suspend fun deleteContactById(id: Int)
}
package com.meliskarci.contactappwithandroidjetpackcompose.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meliskarci.contactappwithandroidjetpackcompose.data.local.ContactEntity
import com.meliskarci.contactappwithandroidjetpackcompose.domain.usecase.DeleteContactByIdUseCase
import com.meliskarci.contactappwithandroidjetpackcompose.domain.usecase.GetAllContactsUseCase
import com.meliskarci.contactappwithandroidjetpackcompose.domain.usecase.InsertContactUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getAllContactUseCase: GetAllContactsUseCase,
    private val insertContactUseCase: InsertContactUseCase,
    private val deleteContactByIdUseCase: DeleteContactByIdUseCase
) : ViewModel() {

    private val _allcontacts = MutableStateFlow<List<ContactEntity>>(emptyList())
    val allContact : StateFlow<List<ContactEntity>>
        get() = _allcontacts.asStateFlow()


    private val _recentAdded = MutableStateFlow<List<ContactEntity>>(emptyList())
    val recentAdded : StateFlow<List<ContactEntity>>
        get() = _recentAdded.asStateFlow()

    init {
        getAllContact()
    }

    fun getAllContact() {
        viewModelScope.launch {
            getAllContactUseCase.invoke().collect { value ->
                _allcontacts.value = value
                _recentAdded.value = value.take(4)
            }
        }
    }



    fun delete(id: Int) {
        viewModelScope.launch {
            deleteContactByIdUseCase(id)
        }
    }
}
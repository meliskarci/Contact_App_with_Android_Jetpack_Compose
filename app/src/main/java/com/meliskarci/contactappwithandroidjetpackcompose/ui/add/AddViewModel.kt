package com.meliskarci.contactappwithandroidjetpackcompose.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meliskarci.contactappwithandroidjetpackcompose.data.local.ContactEntity
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
class AddViewModel @Inject constructor(
    private val insertContactUseCase: InsertContactUseCase
) : ViewModel() {
    fun insert(contact: ContactEntity) {
        viewModelScope.launch {
            insertContactUseCase(contact)
        }
    }

}
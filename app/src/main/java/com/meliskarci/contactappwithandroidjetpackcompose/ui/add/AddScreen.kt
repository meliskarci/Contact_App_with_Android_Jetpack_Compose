package com.meliskarci.contactappwithandroidjetpackcompose.ui.add

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.app.NotificationCompat.Style
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.meliskarci.contactappwithandroidjetpackcompose.R
import com.meliskarci.contactappwithandroidjetpackcompose.data.local.ContactEntity


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddContactScreen(navController: NavController){

    val viewModel = hiltViewModel<AddViewModel>()

    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }



    Scaffold (topBar = {
        CenterAlignedTopAppBar(
            title = { Text("Add Contact", color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.headlineLarge) },
            navigationIcon = {
                IconButton(onClick = {navController.navigateUp()}) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                }
            }
        )
    }){
        Column(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 20.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            TextField(modifier = Modifier.fillMaxWidth().clip(shape = MaterialTheme.shapes.medium),value = name, onValueChange = { name = it}, label = { Text("Name") })
            Spacer(Modifier.padding(15.dp))
            TextField(modifier = Modifier.fillMaxWidth().clip(shape = MaterialTheme.shapes.medium),value = surname, onValueChange = {surname=it}, label = { Text("Surname") })
            Spacer(Modifier.padding(15.dp))
            TextField(modifier = Modifier.fillMaxWidth().clip(shape = MaterialTheme.shapes.medium),value = phone, onValueChange = {phone=it}, label = { Text("Phone") })
            Spacer(Modifier.padding(15.dp))
            TextField(modifier = Modifier.fillMaxWidth().clip(shape = MaterialTheme.shapes.medium),value = email, onValueChange = {email=it}, label = { Text("Email") })
            Spacer(Modifier.padding(15.dp))
            Button(

                onClick = {
                    val contact = ContactEntity(
                        name = name,
                        surname = surname,
                        email = email,
                        phone = phone,
                        image = ""
                    )
                    viewModel.insert(contact = contact)
                    navController.navigateUp()
                },
                colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.onSecondaryContainer)
            ) {
                Text("Add")
            }
        }
    }
}
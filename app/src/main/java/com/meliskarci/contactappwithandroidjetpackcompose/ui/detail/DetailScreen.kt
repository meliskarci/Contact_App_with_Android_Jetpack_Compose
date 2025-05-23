package com.meliskarci.contactappwithandroidjetpackcompose.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.meliskarci.contactappwithandroidjetpackcompose.ui.detail.components.ContactRow


@Composable
fun DetailScreen(navController: NavController) {
    val viewModel = hiltViewModel<DetailViewModel>()
    val contact = viewModel.contact.collectAsStateWithLifecycle()


    var showDialog by remember { mutableStateOf(false) }//SEN EKLEDİN



    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surface).padding(bottom = 16.dp)
    ) {
        //Back Button
        IconButton(
            onClick = { navController.navigateUp() },
            modifier = Modifier
                .padding(start = 16.dp, top = 40.dp)
                .size(40.dp)
                .background(color = Color.Gray.copy(alpha = 0.2f), CircleShape),
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.White
            )
        }

        // Bottom Card with Profile
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .align(Alignment.BottomCenter),
            shape = RoundedCornerShape(50.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.LightGray,
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize().background(MaterialTheme.colorScheme.surfaceContainer)
                    .padding(top = 60.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                //Profile Image
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "${contact.value.name.first()}${contact.value.surname.first()}",
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
                Spacer(modifier = Modifier.height(14.dp))
                // Name
                Text(
                    text = contact.value.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Edit Contact Button
                Row(
                    modifier = Modifier
                        .clickable { }
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit",
                        tint  = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Edit Contact",
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))

                // Contact Information
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    ContactRow(
                        icon = Icons.Default.Phone,
                        title = "Whatsapp",
                        data = "+90 531 470 06 85",
                        isNumber = true
                    )
                    ContactRow(
                        icon = Icons.Default.Email,
                        title = "Email",
                        data = contact.value.email,
                        isNumber = false
                    )
                    //////////// SEN DENEDİN
                    // Silme Butonu
                    Button(
                        onClick = {
                            showDialog = true // Dialog'u göster
                        }, modifier = Modifier.align(Alignment.CenterHorizontally),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.secondaryContainer,
                            contentColor = MaterialTheme.colorScheme.onSecondaryContainer)
                    ) {
                        Text("Delete")
                    }
                }
            }
        }
        //kİŞİ SİLME DİALOGU
        if (showDialog)
            AlertDialog(
                onDismissRequest = {
                    showDialog = false
                },
                confirmButton = {
                    Button(
                        onClick = {
                            viewModel.delete(contact.value.id) // Kişiyi sil
                            showDialog = false
                            navController.navigateUp() // Ana ekrana geri dön
                        }
                    ) {
                        Text("Yes")
                    }
                },
                dismissButton = {
                    Button(
                        onClick = {
                            showDialog = false  // Diyalog kapanacak
                        }
                    ) {
                        Text("No")
                    }
                },
                title = { Text("Delete")
                },
                text = {
                    Text("Are you sure you want to delete this?")
                }
            )
    }
} /// SEN EKLEDİN
package com.meliskarci.contactappwithandroidjetpackcompose.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.meliskarci.contactappwithandroidjetpackcompose.R
import com.meliskarci.contactappwithandroidjetpackcompose.navigation.Screen
import com.meliskarci.contactappwithandroidjetpackcompose.ui.home.components.CustomSearchBar
import com.meliskarci.contactappwithandroidjetpackcompose.ui.home.components.LazyRowComponent


@Composable
fun HomeScreen(navController: NavController) {

    val viewModel = hiltViewModel<HomeScreenViewModel>()

    val allContacts = viewModel.allContact.collectAsStateWithLifecycle()
    val recentAdded = viewModel.recentAdded.collectAsStateWithLifecycle()

    var searchText = remember { mutableStateOf("") }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White).padding(top = 35.dp)) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Text(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                    text = "Contacts",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))
                CustomSearchBar(searchText = searchText)
                Spacer(modifier = Modifier.height(16.dp))
                Text(modifier = Modifier.padding(start = 15.dp), text = "Recent Added", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(8.dp))
                LazyRowComponent(kisiList = recentAdded.value)
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    modifier = Modifier.padding(start = 15.dp),
                    text = "My Contacts (${allContacts.value?.size})",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
            items(allContacts.value.size) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .clickable{ navController.navigate(Screen.Detail(id = allContacts.value[it].id))
                        }
                ) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(Color.LightGray),
                        contentAlignment = Alignment.Center
                    ) {
                        if (allContacts.value[it].image.isEmpty()) {
                            Text(
                                text = "${allContacts.value[it].name.first()}${allContacts.value[it].surname.first()}",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                        } else {
                            Image(
                                painter = painterResource(R.drawable.ic_launcher_background),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                    Spacer(Modifier.width(16.dp))
                    Column {
                        Text(
                            text = "${allContacts.value[it].name} ${allContacts.value[it].surname}",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            text = allContacts.value[it].email,
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }
                }
            }
        }
        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            onClick = { navController.navigate(Screen.Add) },
            containerColor = Color(0xFFFF5722),
            contentColor = Color.White,
            shape = RoundedCornerShape(25.dp)
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add Contact")
        }
    }
}
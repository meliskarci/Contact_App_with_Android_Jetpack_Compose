package com.meliskarci.contactappwithandroidjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ihsanarslan.contactapp.ui.home.HomeScreen
import com.meliskarci.contactappwithandroidjetpackcompose.navigation.Screen.Home
import com.meliskarci.contactappwithandroidjetpackcompose.navigation.Screen.Detail
import com.meliskarci.contactappwithandroidjetpackcompose.navigation.Screen.Add
import com.meliskarci.contactappwithandroidjetpackcompose.ui.add.AddContactScreen
import com.meliskarci.contactappwithandroidjetpackcompose.ui.detail.DetailScreen


@Composable
fun NavigationGraph(
    startDestination: Screen,
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable<Home> {
            HomeScreen(navController = navController)
        }
        composable<Detail> {
            DetailScreen(navController = navController)
        }

        composable<Add> {
            AddContactScreen(navController = navController)
        }
    }
}
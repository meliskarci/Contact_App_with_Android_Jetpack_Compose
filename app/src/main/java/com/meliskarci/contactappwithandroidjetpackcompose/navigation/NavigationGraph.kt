package com.meliskarci.contactappwithandroidjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.meliskarci.contactappwithandroidjetpackcompose.navigation.Screen.Home
import com.meliskarci.contactappwithandroidjetpackcompose.navigation.Screen.Detail
import com.meliskarci.contactappwithandroidjetpackcompose.navigation.Screen.Add
import com.meliskarci.contactappwithandroidjetpackcompose.ui.home.HomeScreen
import com.meliskarci.contactappwithandroidjetpackcompose.ui.home.HomeViewModel
import com.meliskarci.contactappwithandroidjetpackcompose.ui.detail.DetailScreen
import com.meliskarci.contactappwithandroidjetpackcompose.ui.detail.DetailViewModel
import com.meliskarci.contactappwithandroidjetpackcompose.ui.add.AddScreen
import com.meliskarci.contactappwithandroidjetpackcompose.ui.add.AddViewModel

@Composable
fun NavigationGraph(
    navController: NavHostController,
    startDestination: Screen,
    modifier: Modifier = Modifier,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        composable<Home> {
            val viewModel: HomeViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            HomeScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<Detail> {
            val viewModel: DetailViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            DetailScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<Add> {
            val viewModel: AddViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            AddScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
    }
}
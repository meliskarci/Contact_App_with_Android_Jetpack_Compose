package com.meliskarci.contactappwithandroidjetpackcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.meliskarci.contactappwithandroidjetpackcompose.navigation.NavigationGraph
import com.meliskarci.contactappwithandroidjetpackcompose.navigation.Screen.Home
import com.meliskarci.contactappwithandroidjetpackcompose.ui.theme.MyappTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyappTheme {
                NavigationGraph(
                    startDestination = Home,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}
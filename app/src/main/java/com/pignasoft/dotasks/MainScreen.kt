package com.pignasoft.dotasks

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pignasoft.dotasks.ui.theme.DoTasksTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navigationItemsIcons =
        listOf(R.drawable.ic_category_24, R.drawable.ic_tasks_24, R.drawable.ic_account_24)
    val bottomNavigationRouts =
        listOf(NavRoutes.CategoryNav, NavRoutes.TasksNav, NavRoutes.AccountNav)
    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                bottomNavigationRouts.forEachIndexed { index, screen ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                painterResource(id = navigationItemsIcons[index]),
                                contentDescription = stringResource(id = screen.titleResId)
                            )
                        },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding: PaddingValues ->
        NavHost(
            navController,
            startDestination = NavRoutes.TasksNav.route,
            Modifier.padding(innerPadding)
        ) {
            composable(NavRoutes.CategoryNav.route) {
                Greeting("category")
            }
            composable(NavRoutes.TasksNav.route) {
                Greeting("tasks")
            }
            composable(NavRoutes.AccountNav.route) {
                Greeting("account")
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DoTasksTheme {
        MainScreen()
    }
}


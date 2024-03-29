package com.kamalbramwell.dating.navigation.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.kamalbramwell.dating.navigation.navigateSingleTopTo

@Composable
fun DatingScaffold(navController: NavHostController,
                   navBarHandler: NavBarHandler,
                   modifier: Modifier = Modifier,
                   content: @Composable (PaddingValues) -> Unit = {}
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            DatingNavigationBar(
                tabs = BottomBarTab.values(),
                navBarHandler = navBarHandler,
                navigateToRoute = { navController.navigateSingleTopTo(it) }
            )
        },
        content = content
    )
}
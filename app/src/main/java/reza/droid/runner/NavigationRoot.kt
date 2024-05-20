package reza.droid.runner

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navDeepLink
import reza.droid.auth.presentation.intro.IntroScreenRoot
import reza.droid.auth.presentation.login.LoginScreenRoot
import reza.droid.auth.presentation.register.RegisterScreenRoot
import reza.droid.run.presentation.active_run.ActiveRunScreenRoot
import reza.droid.run.presentation.active_run.service.ActiveRunService
import reza.droid.run.presentation.run_overview.RunOverviewScreenRoot

@Composable
fun NavigationRoot(
    navController: NavHostController, isLoggedIn: Boolean
) {

    NavHost(
        navController = navController, startDestination = if (isLoggedIn) "run" else "auth"
    ) {
        authGraph(navController)
        runGraph(navController)
    }

}

private fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation(
        startDestination = "intro", route = "auth"
    ) {
        composable(route = "intro") {
            IntroScreenRoot(onSignUpClick = {
                navController.navigate("register")
            }, onSignInClick = {
                navController.navigate("login")
            })
        }
        composable(route = "register") {
            RegisterScreenRoot(onSignInClick = {
                navController.navigate("login") {
                    popUpTo("register") {
                        inclusive = true
                        saveState = true
                    }
                    restoreState = true
                }
            }, onSuccessfulRegistration = {
                navController.navigate("login")
            })
        }
        composable("login") {
            LoginScreenRoot(onLoginSuccess = {
                navController.navigate("run") {
                    popUpTo("auth") {
                        inclusive = true
                    }
                }
            }, onSignUpClick = {
                navController.navigate("register") {
                    popUpTo("login") {
                        inclusive = true
                        saveState = true
                    }
                    restoreState = true
                }
            })
        }
    }
}

private fun NavGraphBuilder.runGraph(navController: NavHostController) {
    navigation(
        startDestination = "run_overview", route = "run"
    ) {
        composable("run_overview") {
            RunOverviewScreenRoot(
                onLogoutClick = {
                    navController.navigate("auth") {
                        popUpTo("run") {
                            inclusive = true
                        }
                    }
                },
                onStartRunClick = {
                    navController.navigate("active_run")
                }
            )
        }
        composable(
            route = "active_run",
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "runner://active_run"
                }
            )
        ) {
            val context = LocalContext.current
            ActiveRunScreenRoot(
                onBack = {
                    navController.navigateUp()
                },
                onFinish = {
                    navController.navigateUp()
                },
                onServiceToggle = { shouldServiceRun ->
                    if(shouldServiceRun) {
                        context.startService(
                            ActiveRunService.createStartIntent(
                                context = context,
                                activityClass = MainActivity::class.java
                            )
                        )
                    } else {
                        context.startService(
                            ActiveRunService.createStopIntent(context = context,)
                        )
                    }
                }
            )
        }
    }
}
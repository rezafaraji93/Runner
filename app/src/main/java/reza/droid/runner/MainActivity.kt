package reza.droid.runner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import reza.droid.core.presentation.designsystem.RunnerTheme

class MainActivity : ComponentActivity() {

    private val mainViewModel by viewModel<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                mainViewModel.state.isCheckingAuth
            }
        }
        enableEdgeToEdge()
        setContent {
            RunnerTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    if (!mainViewModel.state.isCheckingAuth) {
                        NavigationRoot(navController = navController, isLoggedIn = mainViewModel.state.isLoggedIn)
                    }
                }
            }
        }
    }
}
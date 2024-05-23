package reza.droid.analytics.analytics_feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.play.core.splitcompat.SplitCompat
import org.koin.core.context.loadKoinModules
import reza.droid.analytics.data.di.analyticsModule
import reza.droid.analytics.presentation.AnalyticsDashboardScreenRoot
import reza.droid.analytics.presentation.di.analyticsPresentationModule
import reza.droid.core.presentation.designsystem.RunnerTheme

class AnalyticsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(
            listOf(
                analyticsModule,
                analyticsPresentationModule
            )
        )
        SplitCompat.installActivity(this)
        setContent {
            RunnerTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController, startDestination = "analytics_dashboard"
                ) {
                    composable(route = "analytics_dashboard") {
                        AnalyticsDashboardScreenRoot(
                            onBackClick = ::finish
                        )
                    }
                }
            }
        }
    }

}
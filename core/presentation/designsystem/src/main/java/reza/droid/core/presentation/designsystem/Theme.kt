package reza.droid.core.presentation.designsystem

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import Typography

val DarkColorScheme = darkColorScheme(
    primary = RunnerGreen,
    background = RunnerBlack,
    surface = RunnerDarkGray,
    secondary = RunnerWhite,
    tertiary = RunnerWhite,
    primaryContainer = RunnerGreen30,
    onPrimary = RunnerBlack,
    onBackground = RunnerWhite,
    onSurface = RunnerWhite,
    onSurfaceVariant = RunnerGray
)

@Composable
fun RunnerTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
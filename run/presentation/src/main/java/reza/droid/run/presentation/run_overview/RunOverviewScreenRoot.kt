@file:OptIn(ExperimentalMaterial3Api::class)

package reza.droid.run.presentation.run_overview

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import reza.droid.core.presentation.designsystem.AnalyticsIcon
import reza.droid.core.presentation.designsystem.LogoIcon
import reza.droid.core.presentation.designsystem.LogoutIcon
import reza.droid.core.presentation.designsystem.RunIcon
import reza.droid.core.presentation.designsystem.RunnerTheme
import reza.droid.core.presentation.designsystem.components.RunnerFloatingActionButton
import reza.droid.core.presentation.designsystem.components.RunnerScaffold
import reza.droid.core.presentation.designsystem.components.RunnerToolbar
import reza.droid.core.presentation.designsystem.components.util.DropDownItem
import reza.droid.run.presentation.R

@Composable
fun RunOverviewScreenRoot(
    onStartRunClick: () -> Unit,
    viewModel: RunOverviewViewModel = koinViewModel(),
) {
    RunOverviewScreen(onAction = {
        if (it is RunOverviewAction.OnStartClick) {
            onStartRunClick()
        }
        viewModel.onAction(it)
    })
}

@Composable
private fun RunOverviewScreen(
    onAction: (RunOverviewAction) -> Unit
) {
    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = topAppBarState
    )
    RunnerScaffold(topAppBar = {
        RunnerToolbar(showBackButton = false,
            title = stringResource(id = R.string.runner),
            scrollBehavior = scrollBehavior,
            menuItems = listOf(
                DropDownItem(
                    icon = AnalyticsIcon, title = stringResource(id = R.string.analytics)
                ),
                DropDownItem(
                    icon = LogoutIcon, title = stringResource(id = R.string.logout)
                ),
            ),
            onMenuItemClick = { index ->
                when (index) {
                    0 -> onAction(RunOverviewAction.OnAnalyticsClick)
                    1 -> onAction(RunOverviewAction.OnLogoutClick)
                }
            },
            startContent = {
                Icon(
                    imageVector = LogoIcon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(30.dp)
                )
            })
    }, floatingActionButton = {
        RunnerFloatingActionButton(icon = RunIcon, onClick = {
            onAction(RunOverviewAction.OnStartClick)
        })
    }) { padding ->

    }
}

@Preview
@Composable
private fun RunOverviewScreenPreview() {
    RunnerTheme {
        RunOverviewScreen(onAction = {})
    }
}
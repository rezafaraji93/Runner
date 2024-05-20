@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)

package reza.droid.run.presentation.run_overview

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
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
import reza.droid.run.presentation.run_overview.component.RunListItem

@Composable
fun RunOverviewScreenRoot(
    onStartRunClick: () -> Unit,
    onLogoutClick: () -> Unit,
    viewModel: RunOverviewViewModel = koinViewModel(),
) {
    RunOverviewScreen(state = viewModel.state, onAction = { action ->
        when(action) {
            RunOverviewAction.OnLogoutClick -> onLogoutClick()
            RunOverviewAction.OnStartClick -> onStartRunClick()
            else -> Unit
        }
        viewModel.onAction(action)
    })
}

@Composable
private fun RunOverviewScreen(
    state: RunOverviewState, onAction: (RunOverviewAction) -> Unit
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
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection)
                .padding(horizontal = 16.dp),
            contentPadding = padding,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(items = state.runs, key = { it.id }) {
                RunListItem(
                    runUi = it, onDeleteClick = {
                        onAction(RunOverviewAction.OnDeleteClicked(it))
                    }, modifier = Modifier.animateItemPlacement()
                )
            }
        }
    }
}

@Preview
@Composable
private fun RunOverviewScreenPreview() {
    RunnerTheme {
        RunOverviewScreen(state = RunOverviewState(), onAction = {})
    }
}
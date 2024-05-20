package reza.droid.run.presentation.run_overview

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import reza.droid.core.domain.run.RunRepository
import reza.droid.core.domain.run.SyncRunScheduler
import reza.droid.run.presentation.run_overview.mapper.toRunUi
import kotlin.time.Duration.Companion.minutes

class RunOverviewViewModel(
    private val repository: RunRepository,
    private val syncRunScheduler: SyncRunScheduler
): ViewModel() {

    var state by mutableStateOf(RunOverviewState())
        private set

    init {
        viewModelScope.launch {
            syncRunScheduler.scheduleSync(SyncRunScheduler.SyncType.FetchRuns(30.minutes))
        }
        repository.getRuns().onEach { runs ->
            val runsUi = runs.map { it.toRunUi() }
            state = state.copy(runs = runsUi)
        }.launchIn(viewModelScope)

        viewModelScope.launch {
            repository.syncPendingRuns()
            repository.fetchRuns()
        }
    }

    fun onAction(action: RunOverviewAction) {
        when(action) {
            RunOverviewAction.OnAnalyticsClick -> Unit
            is RunOverviewAction.OnDeleteClicked -> {
                viewModelScope.launch {
                    repository.deleteRun(action.runUi.id)
                }
            }
            RunOverviewAction.OnLogoutClick -> Unit
            RunOverviewAction.OnStartClick -> Unit
        }
    }
}
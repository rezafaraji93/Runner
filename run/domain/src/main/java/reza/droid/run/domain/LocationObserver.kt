package reza.droid.run.domain

import kotlinx.coroutines.flow.Flow
import reza.droid.core.domain.location.LocationWithAltitude

interface LocationObserver {
    fun observeLocation(interval: Long): Flow<LocationWithAltitude>
}
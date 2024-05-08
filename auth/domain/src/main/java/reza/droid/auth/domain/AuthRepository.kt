package reza.droid.auth.domain

import reza.droid.core.domain.util.DataError
import reza.droid.core.domain.util.EmptyResult

interface AuthRepository {
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
}
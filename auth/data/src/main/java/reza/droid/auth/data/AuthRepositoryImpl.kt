package reza.droid.auth.data

import io.ktor.client.HttpClient
import reza.droid.auth.domain.AuthRepository
import reza.droid.core.data.networking.post
import reza.droid.core.domain.util.DataError
import reza.droid.core.domain.util.EmptyResult

class AuthRepositoryImpl(
    private val httpClient: HttpClient
): AuthRepository {
    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }

}
package reza.droid.core.data.auth

import reza.droid.core.domain.AuthInfo

fun AuthInfo.toAuthInfoSerializable() = AuthInfoSerializable(
    accessToken = accessToken, refreshToken = refreshToken, userId = userId
)

fun AuthInfoSerializable.toAuthInfo() = AuthInfo(
    accessToken = accessToken, refreshToken = refreshToken, userId = userId
)
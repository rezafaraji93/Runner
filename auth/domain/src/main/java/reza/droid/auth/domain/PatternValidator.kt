package reza.droid.auth.domain

interface PatternValidator {
    fun matches(value: String): Boolean
}
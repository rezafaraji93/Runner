package reza.droid.auth.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import reza.droid.auth.data.EmailPatternValidator
import reza.droid.auth.domain.PatternValidator
import reza.droid.auth.domain.UserDataValidator

val authDataModule = module {
    single<PatternValidator> { EmailPatternValidator }
    singleOf(::UserDataValidator)
}
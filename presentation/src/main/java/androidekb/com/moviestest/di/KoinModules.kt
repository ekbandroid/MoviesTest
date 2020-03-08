package androidekb.com.moviestest.di

import androidekb.com.moviestest.movies.MoviesListModule
import org.koin.core.module.Module

object KoinModules {
    fun create() = listOf(
        MoviesListModule.create()
    )
}

interface InjectionModule {
    fun create(): Module
}
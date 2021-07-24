package androidekb.com.moviestest.di

import androidekb.com.data.di.DatabaseModule
import androidekb.com.data.di.NetworkModule
import androidekb.com.data.di.MoviesListRepositoryModule
import androidekb.com.moviestest.movies.MoviesListModule

object KoinModules {
    fun create() = listOf(
        AppModule.create(),
        NetworkModule.create(),
        DatabaseModule.create(),
        MoviesListRepositoryModule.create(),
        MoviesListModule.create()
    )
}
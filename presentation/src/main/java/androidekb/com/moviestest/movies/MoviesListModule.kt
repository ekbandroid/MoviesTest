package androidekb.com.moviestest.movies

import androidekb.com.common.di.InjectionModule
import androidekb.com.domain.movies.GetSavedMoviesByYearUseCase
import androidekb.com.domain.movies.LoadMoviesUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object MoviesListModule : InjectionModule {
    override fun create() = module {
        viewModel { MoviesListViewModel(get(), get()) }

        single { LoadMoviesUseCase(get(), get()) }

        single { GetSavedMoviesByYearUseCase(get(), get()) }
    }
}

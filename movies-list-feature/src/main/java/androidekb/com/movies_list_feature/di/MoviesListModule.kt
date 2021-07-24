package androidekb.com.movies_list_feature.di

import androidekb.com.common.di.InjectionModule
import androidekb.com.domain.use_cases.GetSavedMoviesByYearUseCase
import androidekb.com.domain.use_cases.LoadMoviesUseCase
import androidekb.com.movies_list_feature.movies.MoviesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object MoviesListModule : InjectionModule {

    override fun create() = module {
        viewModel { MoviesListViewModel(get(), get()) }

        single { LoadMoviesUseCase(get(), get()) }

        single { GetSavedMoviesByYearUseCase(get(), get()) }
    }
}

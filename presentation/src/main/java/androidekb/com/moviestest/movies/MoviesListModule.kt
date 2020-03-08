package androidekb.com.moviestest.movies

import androidekb.com.moviestest.di.InjectionModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object MoviesListModule: InjectionModule {
    override fun create() = module {
        viewModel { MoviesListViewModel() }
    }
}

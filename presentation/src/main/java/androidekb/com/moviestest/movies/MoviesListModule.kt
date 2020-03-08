package androidekb.com.moviestest.movies

import androidekb.com.data.repositories.Movies.MoviesRemoteGateway
import androidekb.com.data.repositories.Movies.MoviesRemoteGatewayImpl
import androidekb.com.data.repositories.Movies.MoviesRepository
import androidekb.com.data.repositories.Movies.api.MoviesService
import androidekb.com.domain.movies.GetMoviesUseCase
import androidekb.com.moviestest.di.InjectionModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

object MoviesListModule: InjectionModule {
    override fun create() = module {
        viewModel { MoviesListViewModel(get()) }

        single { GetMoviesUseCase( get(), get()) }

        single { MoviesRepository(get()) }

        single<MoviesRemoteGateway> { MoviesRemoteGatewayImpl(get<Retrofit>().create(MoviesService::class.java)) }
    }
}

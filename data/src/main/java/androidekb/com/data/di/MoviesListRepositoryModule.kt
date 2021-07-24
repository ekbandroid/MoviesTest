package androidekb.com.data.di

import androidekb.com.common.di.InjectionModule
import androidekb.com.data.repositories.movies.MoviesLocalGatewayImpl
import androidekb.com.data.repositories.movies.MoviesRemoteGatewayImpl
import androidekb.com.data.repositories.movies.MoviesRepositoryImpl
import androidekb.com.data.repositories.movies.api.MoviesService
import androidekb.com.data.repositories.movies.db.MoviesDatabase
import androidekb.com.domain.repository_interfaces.MoviesLocalGateway
import androidekb.com.domain.repository_interfaces.MoviesRemoteGateway
import androidekb.com.domain.repository_interfaces.MoviesRepository
import org.koin.dsl.module
import retrofit2.Retrofit

object MoviesListRepositoryModule : InjectionModule {

    override fun create() = module {

        single<MoviesRepository> { MoviesRepositoryImpl(get(), get()) }

        single<MoviesRemoteGateway> {
            MoviesRemoteGatewayImpl(get<Retrofit>().create(MoviesService::class.java))
        }

        single { get<MoviesDatabase>().movieDao() }

        single<MoviesLocalGateway> { MoviesLocalGatewayImpl(get()) }
    }
}

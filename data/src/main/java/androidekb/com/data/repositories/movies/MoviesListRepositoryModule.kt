package androidekb.com.data.repositories.movies

import androidekb.com.common.di.InjectionModule
import androidekb.com.data.repositories.movies.api.MoviesService
import androidekb.com.data.repositories.movies.db.MoviesDatabase
import org.koin.dsl.module
import retrofit2.Retrofit

object MoviesListRepositoryModule : InjectionModule {
    override fun create() = module {

        single { MoviesRepository(get(), get()) }

        single<MoviesRemoteGateway> {
            MoviesRemoteGatewayImpl(get<Retrofit>().create(MoviesService::class.java))
        }

        single { get<MoviesDatabase>().movieDao() }

        single { MoviesLocalGateway(get()) }
    }
}

package androidekb.com.domain.movies

import androidekb.com.common.coroutines.AppCoroutineDispatchers
import androidekb.com.data.repositories.movies.MoviesRepository
import androidekb.com.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher


class LoadMoviesUseCase(
    dispatchers: AppCoroutineDispatchers,
    private val moviesRepository: MoviesRepository
) : UseCase<Unit, Unit>() {

    override val dispatcher: CoroutineDispatcher = dispatchers.io

    override suspend fun execute(parameters: Unit) = moviesRepository.loadMovies()
}
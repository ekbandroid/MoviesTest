package androidekb.com.domain.use_cases

import androidekb.com.common.coroutines.AppCoroutineDispatchers
import androidekb.com.domain.UseCase
import androidekb.com.domain.repository_interfaces.MoviesRepository
import kotlinx.coroutines.CoroutineDispatcher


class LoadMoviesUseCase(
    dispatchers: AppCoroutineDispatchers,
    private val moviesRepository: MoviesRepository
) : UseCase<Unit, Unit>() {

    override val dispatcher: CoroutineDispatcher = dispatchers.io

    override suspend fun execute(parameters: Unit) = moviesRepository.loadMovies()
}
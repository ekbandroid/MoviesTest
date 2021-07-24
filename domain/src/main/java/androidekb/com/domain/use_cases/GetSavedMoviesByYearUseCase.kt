package androidekb.com.domain.use_cases

import androidekb.com.common.coroutines.AppCoroutineDispatchers
import androidekb.com.domain.entities.Movie
import androidekb.com.domain.UseCase
import androidekb.com.domain.repository_interfaces.MoviesRepository
import kotlinx.coroutines.CoroutineDispatcher


class GetSavedMoviesByYearUseCase(
    dispatchers: AppCoroutineDispatchers,
    private val moviesRepository: MoviesRepository
) : UseCase<Int?, List<Movie>>() {

    override val dispatcher: CoroutineDispatcher = dispatchers.io

    override suspend fun execute(parameters: Int?): List<Movie> = moviesRepository.getMoviesFromDb(parameters)
}
package androidekb.com.domain.movies

import androidekb.com.common.coroutines.AppCoroutineDispatchers
import androidekb.com.data.entities.Movie
import androidekb.com.data.repositories.movies.MoviesRepository
import androidekb.com.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher


class GetSavedMoviesByYearUseCase(
    dispatchers: AppCoroutineDispatchers,
    private val moviesRepository: MoviesRepository
) : UseCase<Int?, List<Movie>>() {

    override val dispatcher: CoroutineDispatcher = dispatchers.io

    override suspend fun execute(parameters: Int?): List<Movie> = moviesRepository.getMoviesFromDb(parameters)
}
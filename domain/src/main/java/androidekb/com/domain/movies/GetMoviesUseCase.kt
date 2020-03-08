package androidekb.com.domain.movies

import androidekb.com.data.entities.Movie
import androidekb.com.data.repositories.Movies.MoviesRepository
import androidekb.com.domain.AppCoroutineDispatchers
import androidekb.com.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher


class GetMoviesUseCase(
    dispatchers: AppCoroutineDispatchers,
    private val moviesRepository: MoviesRepository
) : UseCase<Unit, List<Movie>>() {

    override val dispatcher: CoroutineDispatcher = dispatchers.io

    override suspend fun execute(parameters: Unit): List<Movie> = moviesRepository.getMovies()
}
package androidekb.com.data.repositories.movies

import androidekb.com.domain.entities.Movie
import androidekb.com.domain.repository_interfaces.MoviesLocalGateway
import androidekb.com.domain.repository_interfaces.MoviesRemoteGateway
import androidekb.com.domain.repository_interfaces.MoviesRepository

class MoviesRepositoryImpl(
    private val moviesLocalGateway: MoviesLocalGateway,
    private val moviesRemoteGateway: MoviesRemoteGateway
) : MoviesRepository {

    override suspend fun loadMovies() {
        val movies = moviesRemoteGateway.getMovies()
        moviesLocalGateway.clear()
        moviesLocalGateway.saveMovies(movies)
    }

    override suspend fun getMoviesFromDb(year: Int?): List<Movie> =
        moviesLocalGateway.getMovies(year)
}
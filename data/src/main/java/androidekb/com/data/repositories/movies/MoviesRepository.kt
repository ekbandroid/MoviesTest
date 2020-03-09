package androidekb.com.data.repositories.movies

import androidekb.com.data.entities.Movie

class MoviesRepository (
    private val moviesLocalGateway: MoviesLocalGateway,
    private val moviesRemoteGateway: MoviesRemoteGateway
) {
    suspend fun loadMovies() {
        val movies = moviesRemoteGateway.getMovies()
        moviesLocalGateway.clear()
        moviesLocalGateway.saveMovies(movies)
    }

    suspend fun getMoviesFromDb(year: Int?): List<Movie> =
        moviesLocalGateway.getMovies(year)
}
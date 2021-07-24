package androidekb.com.domain.repository_interfaces

import androidekb.com.domain.entities.Movie

interface MoviesRepository {

    suspend fun loadMovies()

    suspend fun getMoviesFromDb(year: Int?): List<Movie>
}
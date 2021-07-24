package androidekb.com.domain.repository_interfaces

import androidekb.com.domain.entities.Movie

interface MoviesLocalGateway {

    suspend fun getMovies(year: Int?): List<Movie>

    suspend fun clear()

    suspend fun saveMovies(movies: List<Movie>)
}

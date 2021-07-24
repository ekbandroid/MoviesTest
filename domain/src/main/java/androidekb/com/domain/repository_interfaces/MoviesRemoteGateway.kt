package androidekb.com.domain.repository_interfaces

import androidekb.com.domain.entities.Movie

interface MoviesRemoteGateway {

    suspend fun getMovies(): List<Movie>
}
package androidekb.com.data.repositories.movies

import androidekb.com.data.entities.Movie
import androidekb.com.data.repositories.movies.api.MoviesService


interface MoviesRemoteGateway {
    suspend fun getMovies(): List<Movie>
}

class MoviesRemoteGatewayImpl(private val moviesService: MoviesService) : MoviesRemoteGateway {

    override suspend fun getMovies(): List<Movie> =
        moviesService
            .getMovies()
            .map {
                MovieConverter.fromRemote(it)
            }
}
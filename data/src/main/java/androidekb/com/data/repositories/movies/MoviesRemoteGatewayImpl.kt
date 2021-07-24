package androidekb.com.data.repositories.movies

import androidekb.com.data.repositories.movies.api.MoviesService
import androidekb.com.domain.entities.Movie
import androidekb.com.domain.repository_interfaces.MoviesRemoteGateway

class MoviesRemoteGatewayImpl(private val moviesService: MoviesService) : MoviesRemoteGateway {

    override suspend fun getMovies(): List<Movie> =
        moviesService
            .getMovies()
            .map {
                MovieConverter.fromRemote(it)
            }
}
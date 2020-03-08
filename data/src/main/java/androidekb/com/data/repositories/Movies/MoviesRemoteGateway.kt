package androidekb.com.data.repositories.Movies

import androidekb.com.data.entities.Movie
import androidekb.com.data.repositories.Movies.api.MoviesService


interface MoviesRemoteGateway {
    suspend fun getMovies(): List<Movie>
}

class MoviesRemoteGatewayImpl(private val moviesService: MoviesService) : MoviesRemoteGateway {

    override suspend fun getMovies(): List<Movie> =
        moviesService
            .getMovies()
            .map {
                Movie(
                    id = it.id,
                    imageLink = it.poster?:"",
                    year = it.year?:0
                )
            }
}
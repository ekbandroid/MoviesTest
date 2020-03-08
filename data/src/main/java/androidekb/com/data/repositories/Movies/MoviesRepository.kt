package androidekb.com.data.repositories.Movies

import androidekb.com.data.entities.Movie
import androidekb.com.data.repositories.Movies.api.model.MovieResponse

class MoviesRepository (
   // private val moviesLocalGateway: MoviesLocalGateway,
    private val moviesRemoteGateway: MoviesRemoteGateway
) {
    suspend fun getMovies(): List<Movie> =
        moviesRemoteGateway.getMovies()

//    suspend fun getCachedMovies(year: Int?): List<Movie> =
//        moviesLocalGateway.getMovies(year)
//
//    suspend fun saveCachedMovies(movies:List<Movie>) {
//        moviesLocalGateway.clear()
//        moviesLocalGateway.saveMovies(movies)
//    }
}
package androidekb.com.data.repositories.movies

import androidekb.com.data.entities.Movie

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
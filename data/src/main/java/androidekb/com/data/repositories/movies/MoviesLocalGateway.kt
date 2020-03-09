package androidekb.com.data.repositories.movies

import androidekb.com.data.entities.Movie
import androidekb.com.data.repositories.movies.db.MovieDao

class MoviesLocalGateway(private val movieDao: MovieDao) {
    suspend fun getMovies(year: Int?): List<Movie> =
        if (year != null) {
            movieDao.getMovieByYear(year)
        } else {
            movieDao.getAllMovies()
        }
            .map {
                MovieConverter.fromDatabase(it)
            }

    suspend fun clear() =
        movieDao.deleteAll()

    suspend fun saveMovies(movies: List<Movie>) =
        movieDao.insertList(MovieConverter.toDatabase(movies))

}

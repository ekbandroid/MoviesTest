package androidekb.com.data.repositories.movies

import androidekb.com.data.repositories.movies.db.MovieDao
import androidekb.com.domain.entities.Movie
import androidekb.com.domain.repository_interfaces.MoviesLocalGateway

class MoviesLocalGatewayImpl(private val movieDao: MovieDao) : MoviesLocalGateway {
    override suspend fun getMovies(year: Int?): List<Movie> =
        if (year != null) {
            movieDao.getMovieByYear(year)
        } else {
            movieDao.getAllMovies()
        }.map {
            MovieConverter.fromDatabase(it)
        }

    override suspend fun clear() =
        movieDao.deleteAll()

    override suspend fun saveMovies(movies: List<Movie>) =
        movieDao.insertList(MovieConverter.toDatabase(movies))

}

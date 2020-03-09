package androidekb.com.data.repositories.movies

import androidekb.com.data.repositories.movies.db.model.MovieEntity
import androidekb.com.data.entities.Movie
import androidekb.com.data.repositories.movies.api.model.MovieResponse

object MovieConverter {
    fun fromDatabase(movie: MovieEntity): Movie =
            Movie(
                id = movie.id,
                imageUrl = movie.imageUrl,
                year = movie.year
            )

    private fun toDatabase(movie: Movie): MovieEntity =
        MovieEntity(
            id = movie.id,
            imageUrl = movie.imageUrl,
            year = movie.year
        )

    fun toDatabase(movies:List<Movie>):List<MovieEntity> =
        movies.map {
            toDatabase(
                it
            )
        }

    fun fromRemote(movie:MovieResponse):Movie =
        Movie(
            id = movie.id,
            imageUrl = movie.poster?:"",
            year = movie.year?:0
        )
}
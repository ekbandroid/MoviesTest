package androidekb.com.data.repositories.Movies.api

import androidekb.com.data.repositories.Movies.api.model.MovieResponse
import retrofit2.http.GET

interface MoviesService {
    @GET("ar2code/apitest/master/movies.json")
    suspend fun getMovies(): List<MovieResponse>
}
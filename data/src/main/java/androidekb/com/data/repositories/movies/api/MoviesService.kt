package androidekb.com.data.repositories.movies.api

import androidekb.com.data.repositories.movies.api.model.MovieResponse
import retrofit2.http.GET

interface MoviesService {
    @GET("ar2code/apitest/master/movies.json")
    suspend fun getMovies(): List<MovieResponse>
}
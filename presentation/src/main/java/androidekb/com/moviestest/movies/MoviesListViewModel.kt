package androidekb.com.moviestest.movies

import androidekb.com.moviestest.ui.main.movies.model.Movie
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MoviesListViewModel : ViewModel() {
    private val _moviesList = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>>
        get() =_moviesList

}

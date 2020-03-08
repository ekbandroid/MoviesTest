package androidekb.com.moviestest.movies

import androidekb.com.data.entities.Movie
import androidekb.com.domain.movies.GetMoviesUseCase
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MoviesListViewModel(getMoviesUseCase: GetMoviesUseCase) : ViewModel() {
    private val _moviesList = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>>
        get() = _moviesList

    init {
        viewModelScope.launch {
            try {
                _moviesList.value = getMoviesUseCase.invoke(Unit)
            } catch (e: Exception) {

            }
        }
        }
    }

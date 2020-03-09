package androidekb.com.moviestest.movies

import androidekb.com.data.entities.Movie
import androidekb.com.domain.movies.GetSavedMoviesByYearUseCase
import androidekb.com.domain.movies.LoadMoviesUseCase
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MoviesListViewModel(
    private val loadMoviesUseCase: LoadMoviesUseCase,
    private val getSavedMoviesByYearUseCase: GetSavedMoviesByYearUseCase
) : ViewModel() {

    companion object {
        const val FILTER_2020_YEAR = 2020
    }

    private val _moviesList = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>>
        get() = _moviesList
    private var yearFilter: Int? = null

    init {
        viewModelScope.launch {
            try {
                loadMoviesUseCase.invoke(Unit)
                _moviesList.value = getSavedMoviesByYearUseCase.invoke(yearFilter)
            } catch (e: Exception) {

            }
        }
    }

    fun setFilter(checked: Boolean) {
        yearFilter = if (checked) FILTER_2020_YEAR else null
        viewModelScope.launch {
            try {
                _moviesList.value = getSavedMoviesByYearUseCase.invoke(yearFilter)
            } catch (e: Exception) {

            }
        }
    }
}

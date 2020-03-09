package androidekb.com.moviestest.movies

import androidekb.com.data.entities.Movie
import androidekb.com.domain.movies.GetSavedMoviesByYearUseCase
import androidekb.com.domain.movies.LoadMoviesUseCase
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import timber.log.Timber

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

    private val _showProgress = MutableLiveData<Boolean>()
    val showProgress: LiveData<Boolean>
        get() = _showProgress

    private val _showError = MutableLiveData<Boolean>()
    val showError: LiveData<Boolean>
        get() = _showError
    private var yearFilter: Int? = null

    init {
        load()
    }

    fun load() {
        showProgress()
        viewModelScope.launch {
            try {
                loadMoviesUseCase.invoke(Unit)
            } catch (e: Exception) {
                Timber.e(e, "Error load movies from server. Trying to get them from the DB")
            }
            showSavedMovies()
        }
    }

    fun setFilter(checked: Boolean) {
        showProgress()
        yearFilter = if (checked) FILTER_2020_YEAR else null
        showSavedMovies()
    }

    private fun showSavedMovies() {
        var movies = emptyList<Movie>()
        viewModelScope.launch {
            try {
                movies = getSavedMoviesByYearUseCase.invoke(yearFilter)
            } catch (e: Exception) {
                Timber.e(e, "Error get movies from DB")
            }
            if (movies.isEmpty()) {
                showError()
            } else {
                _showProgress.postValue(false)
                _moviesList.value = movies
            }
        }
    }

    private fun showError() {
        _showProgress.postValue(false)
        _showError.postValue(true)
    }

    private fun showProgress() {
        _showProgress.postValue(true)
        _showError.postValue(false)
    }
}

package androidekb.com.movies_list_feature.movies

import androidekb.com.domain.entities.Movie
import androidekb.com.domain.use_cases.GetSavedMoviesByYearUseCase
import androidekb.com.domain.use_cases.LoadMoviesUseCase
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

    private val _moviesState = MutableLiveData<MoviesState>()
    val moviesState: LiveData<MoviesState>
        get() = _moviesState

    private var yearFilter: Int? = null

    init {
        load()
    }

    fun load() {
        _moviesState.postValue(MoviesState.InProgress)
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
        _moviesState.postValue(MoviesState.InProgress)
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
                _moviesState.postValue(MoviesState.Error)
            } else {
                _moviesState.postValue(MoviesState.Loaded(movies))
            }
        }
    }
}

sealed class MoviesState {
    class Loaded(val moviesList: List<Movie>) : MoviesState()
    object InProgress : MoviesState()
    object Error : MoviesState()
}
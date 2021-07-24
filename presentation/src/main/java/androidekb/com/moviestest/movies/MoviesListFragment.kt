package androidekb.com.moviestest.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidekb.com.domain.entities.Movie
import androidekb.com.moviestest.R
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.movies_list_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesListFragment : Fragment() {

    companion object {
        fun newInstance() = MoviesListFragment()
    }

    private val viewModel: MoviesListViewModel by viewModel()
    private val moviesAdapter by lazy {
        MoviesAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.movies_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMoviesRecyclerView()
        setListeners()
        observeMoviesState()
    }

    private fun initMoviesRecyclerView() {
        with(moviesRecyclerView) {
            adapter = moviesAdapter
            addItemDecoration(
                MoviesItemDecorator(
                    resources.getDimension(R.dimen.padding_4dp).toInt()
                )
            )
        }
    }

    private fun setListeners() {
        moviesFilterSwitch.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setFilter(isChecked)
        }

        loadingStateView.setOnRefreshClickListener {
            viewModel.load()
        }
    }

    private fun observeMoviesState() {
        viewModel.moviesState.observe(
            viewLifecycleOwner,
            Observer { state ->
                when (state) {
                    is MoviesState.InProgress -> loadingStateView.showLoadingState()
                    is MoviesState.Loaded -> {
                        loadingStateView.showLoadedState()
                        showMoviesList(state.moviesList)
                    }
                    is MoviesState.Error -> loadingStateView.showErrorState()
                }
            }
        )
    }

    private fun showMoviesList(moviesList: List<Movie>) {
        with(moviesAdapter) {
            submitList(moviesList)
            notifyDataSetChanged()
        }
        with(moviesRecyclerView) {
            moviesRecyclerView.post {
                scrollToPosition(0)
            }
        }
    }
}


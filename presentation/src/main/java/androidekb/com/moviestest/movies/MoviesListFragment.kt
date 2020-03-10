package androidekb.com.moviestest.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.movies_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val moviesAdapter = MoviesAdapter()
        with(moviesRecyclerView) {
            adapter = moviesAdapter
            addItemDecoration(
                MoviesItemDecorator(
                    resources.getDimension(R.dimen.padding_4dp).toInt()
                )
            )
        }
        moviesFilterSwitch.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setFilter(isChecked)
        }
        loadingStateView.setOnRefreshListener { viewModel.load() }
        with(viewModel) {
            moviesList.observe(
                viewLifecycleOwner,
                Observer { moviesList ->
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
            )
            loadingState.observe(
                viewLifecycleOwner,
                Observer { state ->
                    when (state) {
                        is LoadingState.InProgress -> loadingStateView.showLoadingState()
                        is LoadingState.Loaded -> loadingStateView.showLoadedState()
                        is LoadingState.Error -> loadingStateView.showErrorState()
                    }
                }
            )
        }
    }
}


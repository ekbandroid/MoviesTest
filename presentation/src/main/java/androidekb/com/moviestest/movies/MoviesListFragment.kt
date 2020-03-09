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
import androidx.core.view.isVisible

class MoviesListFragment : Fragment() {

    companion object {
        fun newInstance() = MoviesListFragment()
    }

    private val viewModel: MoviesListViewModel by viewModel()
    private val moviesAdapter = MoviesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.movies_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
        retryButton.setOnClickListener {
            viewModel.load()
        }
        with(viewModel) {
            moviesList.observe(
                this@MoviesListFragment,
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
            showProgress.observe(
                this@MoviesListFragment,
                Observer { isShow ->
                    progressBarLayout.isVisible = isShow
                }
            )
            showError.observe(
                this@MoviesListFragment,
                Observer { isShow ->
                    errorLayout.isVisible = isShow
                }
            )
        }
    }
}


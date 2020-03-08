package androidekb.com.moviestest.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidekb.com.moviestest.R
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.movies_list_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesListFragment : Fragment() {

    companion object {
        fun newInstance() =
            MoviesListFragment()
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
        moviesRecyclerView.adapter = moviesAdapter

        viewModel.moviesList.observe(this, Observer { moviesList ->
            moviesAdapter.submitList(moviesList)
            moviesAdapter.notifyDataSetChanged()
        }
        )
    }

}

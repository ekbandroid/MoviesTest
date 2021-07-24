package androidekb.com.moviestest.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidekb.com.domain.entities.Movie
import androidekb.com.moviestest.GlideApp
import androidekb.com.moviestest.R
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.movie_item.view.*

class MoviesAdapter :
    androidx.recyclerview.widget.ListAdapter<Movie, MovieRepositoryViewHolder>(asyncDifferConfig) {
    companion object {
        val asyncDifferConfig = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieRepositoryViewHolder(parent)


    override fun onBindViewHolder(holder: MovieRepositoryViewHolder, position: Int) =
        holder.bind(getItem(position))
}

class MovieRepositoryViewHolder(parent: ViewGroup) :
    RecyclerView.ViewHolder(
        LayoutInflater
            .from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
    ) {
    private val movieImageView: ImageView = itemView.movieImageView

    fun bind(item: Movie) {
        GlideApp.with(movieImageView.context)
            .load(item.imageUrl)
            .into(movieImageView)
    }
}
package androidekb.com.movies_list_feature.movies

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class MoviesItemDecorator(private val padding: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.right = padding
        outRect.left = padding
        outRect.top = padding
        outRect.bottom = padding
    }
}
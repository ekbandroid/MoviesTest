package androidekb.com.moviestest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidekb.com.movies_list_feature.movies.MoviesListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MoviesListFragment.newInstance())
                .commitNow()
        }
    }

}

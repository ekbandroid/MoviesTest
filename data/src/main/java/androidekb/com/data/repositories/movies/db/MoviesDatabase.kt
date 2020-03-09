package androidekb.com.data.repositories.movies.db

import androidekb.com.data.repositories.movies.db.MoviesDatabase.Companion.DATABASE_VERSION
import androidekb.com.data.repositories.movies.db.model.MovieEntity
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        MovieEntity::class
    ],
    version = DATABASE_VERSION,
    exportSchema = false
)

abstract class MoviesDatabase : RoomDatabase() {
    companion object {
        const val DATABASE_VERSION = 1
    }

    abstract fun movieDao(): MovieDao
}
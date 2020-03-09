package androidekb.com.data.repositories.movies.db

import androidekb.com.data.repositories.movies.db.model.MovieEntity
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(posters: List<MovieEntity>)

    @Query("SELECT * FROM ${MovieEntity.TABLE_NAME} WHERE ${MovieEntity.COLUMN_YEAR}=:year")
    suspend fun getMovieByYear(year: Int): List<MovieEntity>

    @Query("SELECT * FROM ${MovieEntity.TABLE_NAME}")
    suspend fun getAllMovies(): List<MovieEntity>

    @Query("DELETE FROM ${MovieEntity.TABLE_NAME}")
    suspend fun deleteAll()
}
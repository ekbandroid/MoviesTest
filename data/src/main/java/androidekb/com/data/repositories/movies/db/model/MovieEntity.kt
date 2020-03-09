package androidekb.com.data.repositories.movies.db.model

import androidekb.com.data.repositories.movies.db.model.MovieEntity.Companion.TABLE_NAME
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = TABLE_NAME)
class MovieEntity(
    @PrimaryKey
    @NotNull
    @ColumnInfo(name = COLUMN_ID)
    val id: String = "",
    @ColumnInfo(name = COLUMN_IMAGE_URL)
    val imageUrl: String,
    @ColumnInfo(name = COLUMN_YEAR)
    val year: Int
) {
    companion object {
        const val TABLE_NAME = "movies"
        const val COLUMN_ID = "id"
        const val COLUMN_IMAGE_URL = "image_url"
        const val COLUMN_YEAR = "year"
    }
}
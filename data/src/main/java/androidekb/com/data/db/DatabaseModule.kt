package androidekb.com.data.db

import androidekb.com.common.di.InjectionModule
import androidekb.com.data.repositories.movies.db.MoviesDatabase
import androidx.room.Room
import org.koin.dsl.module
import java.util.concurrent.Executors

object DatabaseModule: InjectionModule {
    private const val DATABASE_NAME = "movies.db"

    override fun create() = module {
        single {
            Room.databaseBuilder(
                get(),
                MoviesDatabase::class.java,
                DATABASE_NAME
            )
                .fallbackToDestructiveMigration()
                .setQueryExecutor(Executors.newCachedThreadPool())
                .build()
        }
    }
}
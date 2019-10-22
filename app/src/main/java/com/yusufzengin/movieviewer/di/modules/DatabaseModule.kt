package com.yusufzengin.movieviewer.di.modules

import android.content.Context
import androidx.room.Room
import com.yusufzengin.movieviewer.db.AppDatabase
import com.yusufzengin.movieviewer.db.MovieDao
import com.yusufzengin.movieviewer.db.ShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun bindDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "movie")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(db: AppDatabase): MovieDao {
        return db.movieDao()
    }

    @Singleton
    @Provides
    fun provideShowDao(db: AppDatabase): ShowDao {
        return db.showDao()
    }
}
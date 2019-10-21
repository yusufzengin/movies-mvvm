package com.yusufzengin.movieviewer.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yusufzengin.movieviewer.model.data.Movie
import com.yusufzengin.movieviewer.model.data.Show

@Database(version = 1, entities = [Movie::class, Show::class])
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    abstract fun showDao(): ShowDao
}
package com.yusufzengin.movieviewer.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yusufzengin.movieviewer.model.data.Show

@Dao
interface ShowDao {

    @Insert
    suspend fun insertShow(show: Show)

    @Update
    suspend fun updateShow(show: Show)

    @Delete
    suspend fun deleteShow(show: Show)

    @Query("SELECT * FROM tv_shows WHERE id = :id")
    suspend fun getShow(id: Int): Show?

    @Query("SELECT * FROM tv_shows ORDER BY originalName ASC")
    fun getAllShows(): LiveData<List<Show>>
}
package com.yusufzengin.movieviewer.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yusufzengin.movieviewer.model.data.Movie

@Dao
interface MovieDao {

    @Insert
    suspend fun insertMovie(movie: Movie)

    @Update
    suspend fun updateMovie(movie: Movie)

    @Delete
    suspend fun deleteMovie(movie: Movie)

    @Query("SELECT * FROM movies WHERE id = :id")
    suspend fun getMovie(id: Int): Movie?

    @Query("SELECT * FROM movies ORDER BY title ASC")
    fun getAllMovies(): LiveData<List<Movie>>
}
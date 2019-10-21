package com.yusufzengin.movieviewer.model.repository

import com.yusufzengin.movieviewer.api.MovieApi
import com.yusufzengin.movieviewer.db.MovieDao
import com.yusufzengin.movieviewer.model.data.Movie
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieDao: MovieDao,
    private val movieApi: MovieApi
) {
    suspend fun insertMovie(movie: Movie) {
        movieDao.insertMovie(movie)
    }

    suspend fun updateMovie(movie: Movie) {
        movieDao.updateMovie(movie)
    }

    suspend fun deleteMovie(movie: Movie) {
        movieDao.deleteMovie(movie)
    }

    suspend fun isMovieFavorite(id: Int) = movieDao.getMovie(id) != null

    fun getFavoriteMovies() = movieDao.getAllMovies()

    suspend fun fetchTopMovies() = movieApi.getTopMovies().results

    suspend fun fetchMovieDetails(id: Int) = movieApi.getMovieDetails(id)

}
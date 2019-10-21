package com.yusufzengin.movieviewer.api

import com.yusufzengin.movieviewer.model.data.Movie
import com.yusufzengin.movieviewer.model.data.ResultWrapper
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {

    @GET("4/discover/movie?sort_by=popularity.desc")
    suspend fun getTopMovies(): ResultWrapper<Movie>

    @GET("3/movie/{movieId}")
    suspend fun getMovieDetails(@Path("movieId") movieId: Int): Movie

}
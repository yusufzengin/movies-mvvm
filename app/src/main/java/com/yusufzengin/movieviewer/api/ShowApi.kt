package com.yusufzengin.movieviewer.api

import com.yusufzengin.movieviewer.model.data.ResultWrapper
import com.yusufzengin.movieviewer.model.data.Show
import retrofit2.http.GET
import retrofit2.http.Path

interface ShowApi {

    @GET("4/discover/tv?sort_by=popularity.desc")
    suspend fun getTopShows(): ResultWrapper<Show>

    @GET("3/tv/{tv_id}")
    suspend fun getShowDetails(@Path("tv_id") movieId: Int): Show

}
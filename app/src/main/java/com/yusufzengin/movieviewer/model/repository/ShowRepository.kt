package com.yusufzengin.movieviewer.model.repository

import com.yusufzengin.movieviewer.api.ShowApi
import com.yusufzengin.movieviewer.db.ShowDao
import com.yusufzengin.movieviewer.model.data.Show
import javax.inject.Inject

class ShowRepository @Inject constructor(
    private val showDao: ShowDao,
    private val showApi: ShowApi
) {
    suspend fun insertShow(show: Show) {
        showDao.insertShow(show)
    }

    suspend fun updateShow(show: Show) {
        showDao.updateShow(show)
    }

    suspend fun deleteShow(show: Show) {
        showDao.deleteShow(show)
    }

    suspend fun isShowFavorite(id: Int) = showDao.getShow(id) != null

    fun getFavoriteShows() = showDao.getAllShows()

    suspend fun fetchTopShows() = showApi.getTopShows().results

    suspend fun fetchShowDetails(id: Int) = showApi.getShowDetails(id)
}
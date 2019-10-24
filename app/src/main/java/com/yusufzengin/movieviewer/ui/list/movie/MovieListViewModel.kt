package com.yusufzengin.movieviewer.ui.list.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.yusufzengin.movieviewer.model.repository.MovieRepository
import javax.inject.Inject

class MovieListViewModel @Inject constructor(private val repository: MovieRepository) :
    ViewModel() {
    val topMovies = liveData {
        try {
            emit(repository.fetchTopMovies())
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
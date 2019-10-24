package com.yusufzengin.movieviewer.ui.list.movie

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.yusufzengin.movieviewer.model.repository.MovieRepository
import javax.inject.Inject

class MovieListViewModel @Inject constructor(private val repository: MovieRepository) :
    ViewModel() {
    val topMovies = liveData {
        emit(repository.fetchTopMovies())
    }
}
package com.yusufzengin.movieviewer.ui.detail.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import com.yusufzengin.movieviewer.model.repository.MovieRepository
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(private val repository: MovieRepository) :
    ViewModel() {
    private val movieId: MutableLiveData<Int> = MutableLiveData()
    val movie = movieId.switchMap {
        liveData {
            emit(repository.fetchMovieDetails(it))
        }
    }

    fun setMovieId(id: Int) {
        movieId.value = id
    }
}

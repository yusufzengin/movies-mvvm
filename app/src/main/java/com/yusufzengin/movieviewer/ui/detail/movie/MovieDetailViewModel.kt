package com.yusufzengin.movieviewer.ui.detail.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusufzengin.movieviewer.model.data.Movie
import com.yusufzengin.movieviewer.model.repository.MovieRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(private val repository: MovieRepository) :
    ViewModel() {
    private val _movie: MutableLiveData<Movie> = MutableLiveData()
    val movie: LiveData<Movie>
        get() = _movie

    fun fetchMovieDetails(id: Int) {
        viewModelScope.launch {
            // TODO error handling
            try {
                _movie.value = repository.fetchMovieDetails(id)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

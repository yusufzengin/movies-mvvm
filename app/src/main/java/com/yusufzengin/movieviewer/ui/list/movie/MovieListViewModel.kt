package com.yusufzengin.movieviewer.ui.list.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusufzengin.movieviewer.model.data.Movie
import com.yusufzengin.movieviewer.model.repository.MovieRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieListViewModel @Inject constructor(private val repository: MovieRepository) :
    ViewModel() {
    private val _topMovies: MutableLiveData<List<Movie>> = MutableLiveData()
    val topMovies: LiveData<List<Movie>>
        get() = _topMovies

    init {
        fetchTopMovies()
    }

    private fun fetchTopMovies() {
        viewModelScope.launch {
            try {
                _topMovies.value = repository.fetchTopMovies()
                Log.d("TAG1", "${_topMovies.value}")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
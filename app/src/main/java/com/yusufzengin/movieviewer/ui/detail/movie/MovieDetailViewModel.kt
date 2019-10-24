package com.yusufzengin.movieviewer.ui.detail.movie

import androidx.lifecycle.*
import com.yusufzengin.movieviewer.model.repository.MovieRepository
import kotlinx.coroutines.launch
import java.lang.Exception
import java.net.UnknownHostException
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(private val repository: MovieRepository) :
    ViewModel() {
    private val movieId: MutableLiveData<Int> = MutableLiveData(0)
    val movie = movieId.switchMap {
        liveData {
            try {
                emit(repository.fetchMovieDetails(it))
            } catch (e: UnknownHostException) {
                emit(repository.getMovieDetails(it))
            }
        }
    }

    private val _isFavorite: MutableLiveData<Boolean> = MutableLiveData()
    val isFavorite: LiveData<Boolean>
        get() = _isFavorite


    fun setMovieId(id: Int) {
        movieId.value = id
        setInitialFavoriteStatus(id)
    }

    fun toggleFavorites() {
        movie.value?.let { movie ->
            viewModelScope.launch {
                isFavorite.value?.let {
                    if (it) {
                        repository.deleteMovie(movie)
                    } else {
                        repository.insertMovie(movie)
                    }
                    _isFavorite.value = !it
                }
            }
        }
    }

    private fun setInitialFavoriteStatus(id: Int) {
        viewModelScope.launch {
            _isFavorite.value = repository.isMovieFavorite(id)
        }
    }


}

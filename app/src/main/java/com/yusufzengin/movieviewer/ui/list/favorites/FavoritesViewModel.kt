package com.yusufzengin.movieviewer.ui.list.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yusufzengin.movieviewer.model.data.Movie
import com.yusufzengin.movieviewer.model.repository.MovieRepository
import javax.inject.Inject

class FavoritesViewModel @Inject constructor(private val repository: MovieRepository) :
    ViewModel() {

    val favorites: LiveData<List<Movie>>
        get() = repository.getFavoriteMovies()
}

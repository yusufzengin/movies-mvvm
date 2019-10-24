package com.yusufzengin.movieviewer.ui.list.show

import androidx.lifecycle.*
import com.yusufzengin.movieviewer.model.data.Show
import com.yusufzengin.movieviewer.model.repository.ShowRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class ShowListViewModel @Inject constructor(private val repository: ShowRepository) :
    ViewModel() {
    val topShows = liveData {
        emit(repository.fetchTopShows())
    }
}
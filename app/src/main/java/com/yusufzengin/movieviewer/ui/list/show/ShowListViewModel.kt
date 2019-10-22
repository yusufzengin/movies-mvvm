package com.yusufzengin.movieviewer.ui.list.show

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusufzengin.movieviewer.model.data.Show
import com.yusufzengin.movieviewer.model.repository.ShowRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class ShowListViewModel @Inject constructor(private val repository: ShowRepository) :
    ViewModel() {
    private val _topShows: MutableLiveData<List<Show>> = MutableLiveData()
    val topShows: LiveData<List<Show>>
        get() = _topShows

    init {
        fetchTopShows()
    }

    private fun fetchTopShows() {
        viewModelScope.launch {
            try {
                _topShows.value = repository.fetchTopShows()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
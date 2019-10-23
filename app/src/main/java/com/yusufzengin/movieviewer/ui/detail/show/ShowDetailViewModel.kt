package com.yusufzengin.movieviewer.ui.detail.show

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusufzengin.movieviewer.model.data.Show
import com.yusufzengin.movieviewer.model.repository.ShowRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class ShowDetailViewModel @Inject constructor(private val repository: ShowRepository) :
    ViewModel() {
    private val _show: MutableLiveData<Show> = MutableLiveData()
    val show: LiveData<Show>
        get() = _show

    fun fetchShowDetails(id: Int) {
        viewModelScope.launch {
            // TODO error handling
            try {
                _show.value = repository.fetchShowDetails(id)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
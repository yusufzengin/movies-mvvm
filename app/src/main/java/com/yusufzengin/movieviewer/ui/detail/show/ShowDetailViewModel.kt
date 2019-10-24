package com.yusufzengin.movieviewer.ui.detail.show

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import com.yusufzengin.movieviewer.model.repository.ShowRepository
import javax.inject.Inject

class ShowDetailViewModel @Inject constructor(private val repository: ShowRepository) :
    ViewModel() {
    private val showId: MutableLiveData<Int> = MutableLiveData()
    val show = showId.switchMap {
        liveData {
            emit(repository.fetchShowDetails(it))
        }
    }

    fun setShowId(id: Int) {
        showId.value = id
    }
}
package com.yusufzengin.movieviewer.ui.list.show

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.yusufzengin.movieviewer.R

class ShowListFragment : Fragment() {

    companion object {
        fun newInstance() = ShowListFragment()
    }

    private lateinit var viewModel: ShowListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.show_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ShowListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}

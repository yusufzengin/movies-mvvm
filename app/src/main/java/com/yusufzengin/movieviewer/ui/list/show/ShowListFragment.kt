package com.yusufzengin.movieviewer.ui.list.show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yusufzengin.movieviewer.R
import com.yusufzengin.movieviewer.model.data.Show
import com.yusufzengin.movieviewer.ui.adapters.ShowListAdapter
import com.yusufzengin.movieviewer.util.RecyclerViewDecoration
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.show_list_fragment.*
import javax.inject.Inject

class ShowListFragment : DaggerFragment(), ShowListAdapter.OnItemClickListener {

    companion object {
        fun newInstance() = ShowListFragment()
    }

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: ShowListViewModel by viewModels(factoryProducer = { factory })

    private val showAdapter = ShowListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.show_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setUpRecyclerView()

        viewModel.topShows.observe(this) {
            showAdapter.submitList(it)
        }
    }

    private fun setUpRecyclerView() {
        showAdapter.setOnItemClickListener(this)
        val margin =
            (resources.getDimension(R.dimen.rv_item_margin) * resources.displayMetrics.density).toInt()
        show_list_rv.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = showAdapter
            addItemDecoration(RecyclerViewDecoration(margin))
            setHasFixedSize(true)
        }
    }

    override fun onItemClicked(show: Show) {
        val action =
            ShowListFragmentDirections.actionToShowDetailFragment(show.id, show.originalName)
        findNavController().navigate(action)
    }

}

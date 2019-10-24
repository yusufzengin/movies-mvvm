package com.yusufzengin.movieviewer.ui.list.favorites

import android.os.Bundle
import android.util.Log
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
import com.yusufzengin.movieviewer.model.data.Movie
import com.yusufzengin.movieviewer.ui.adapters.MovieListAdapter
import com.yusufzengin.movieviewer.util.RecyclerViewDecoration
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.favorites_fragment.*
import javax.inject.Inject

class FavoritesFragment : DaggerFragment(), MovieListAdapter.OnItemClickListener {

    companion object {
        fun newInstance() = FavoritesFragment()
    }

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: FavoritesViewModel by viewModels(factoryProducer = { factory })

    private val favoritesAdapter = MovieListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.favorites_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setUpRecyclerView()

        viewModel.favorites.observe(this) {
            favoritesAdapter.submitList(it)
        }
    }

    private fun setUpRecyclerView() {
        favoritesAdapter.setOnItemClickListener(this)
        val margin =
            (resources.getDimension(R.dimen.rv_item_margin) * resources.displayMetrics.density).toInt()
        favorites_rv.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = favoritesAdapter
            addItemDecoration(RecyclerViewDecoration(margin))
            setHasFixedSize(true)
        }
    }

    override fun onItemClicked(movie: Movie) {
        val action = FavoritesFragmentDirections
            .actionFavoritesFragmentToMovieDetail(movie.id, movie.title, movie)
        findNavController().navigate(action)
    }
}

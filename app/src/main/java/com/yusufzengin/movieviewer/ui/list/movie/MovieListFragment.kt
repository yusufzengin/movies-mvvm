package com.yusufzengin.movieviewer.ui.list.movie

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yusufzengin.movieviewer.MyApp
import com.yusufzengin.movieviewer.R
import com.yusufzengin.movieviewer.model.data.Movie
import com.yusufzengin.movieviewer.ui.adapters.MovieListAdapter
import com.yusufzengin.movieviewer.util.RecyclerViewDecoration
import kotlinx.android.synthetic.main.movie_list_fragment.*
import javax.inject.Inject

class MovieListFragment : Fragment(), MovieListAdapter.OnItemClickListener {

    companion object {
        fun newInstance() = MovieListFragment()
    }

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: MovieListViewModel by viewModels(factoryProducer = { factory })

    private val movieAdapter = MovieListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_list_fragment, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as MyApp).getAppComponent().newFragmentComponent().inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setUpRecyclerView()

        viewModel.topMovies.observe(this) {
            movieAdapter.submitList(it)
        }
    }

    private fun setUpRecyclerView() {
        movieAdapter.setOnItemClickListener(this)
        val margin =
            (resources.getDimension(R.dimen.rv_item_margin) * resources.displayMetrics.density).toInt()
        movie_list_rv.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = movieAdapter
            addItemDecoration(RecyclerViewDecoration(margin))
            setHasFixedSize(true)
        }
    }

    override fun onItemClicked(movie: Movie) {
        val action = MovieListFragmentDirections
            .actionToMovieDetail(movie.id, movie.title)
        findNavController().navigate(action)
    }

}

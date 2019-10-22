package com.yusufzengin.movieviewer.ui.detail.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import com.yusufzengin.movieviewer.R
import com.yusufzengin.movieviewer.model.data.Movie
import com.yusufzengin.movieviewer.model.data.getPosterUrl
import com.yusufzengin.movieviewer.util.formatDate
import com.yusufzengin.movieviewer.util.loadFromUrl
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.movie_detail_fragment.*
import javax.inject.Inject

class MovieDetailFragment : DaggerFragment() {

    companion object {
        fun newInstance() = MovieDetailFragment()
    }

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: MovieDetailViewModel by viewModels(factoryProducer = { factory })

    val args: MovieDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val movieId = args.movieId
        if (savedInstanceState == null) {
            viewModel.fetchMovieDetails(movieId)
        }
        viewModel.movie.observe(this) {
            setUpUi(it)
        }
    }

    private fun setUpUi(movie: Movie) {
        detail_image.loadFromUrl(movie.getPosterUrl())
        detail_title_tv.text = movie.title
        detail_release_date_tv.text = movie.releaseDate?.formatDate() ?: "-"
        detail_average_tv.text = movie.voteAverage.toString()
        detail_overview_tv.text = movie.overview
    }

}

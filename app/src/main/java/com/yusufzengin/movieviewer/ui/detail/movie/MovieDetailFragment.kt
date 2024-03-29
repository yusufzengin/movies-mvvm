package com.yusufzengin.movieviewer.ui.detail.movie

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import com.yusufzengin.movieviewer.MyApp
import com.yusufzengin.movieviewer.R
import com.yusufzengin.movieviewer.model.data.Movie
import com.yusufzengin.movieviewer.model.data.getPosterUrl
import com.yusufzengin.movieviewer.util.formatDate
import com.yusufzengin.movieviewer.util.loadFromUrl
import kotlinx.android.synthetic.main.movie_detail_fragment.*
import javax.inject.Inject

class MovieDetailFragment : Fragment() {

    companion object {
        fun newInstance() = MovieDetailFragment()
    }

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: MovieDetailViewModel by viewModels(factoryProducer = { factory })

    private val args: MovieDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_detail_fragment, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as MyApp).getAppComponent().newFragmentComponent().inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.setMovieId(args.movieId)
        viewModel.movie.observe(this) {
            setUpUi(it!!)
        }

        viewModel.isFavorite.observe(this) {
            if (it) {
                detail_favorite_btn.setImageResource(R.drawable.ic_favorite)
            } else {
                detail_favorite_btn.setImageResource(R.drawable.ic_favorite_empty)
            }
        }

        detail_favorite_btn.setOnClickListener {
            viewModel.toggleFavorites()
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

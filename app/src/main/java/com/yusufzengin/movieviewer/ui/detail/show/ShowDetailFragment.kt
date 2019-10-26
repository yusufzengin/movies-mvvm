package com.yusufzengin.movieviewer.ui.detail.show

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
import com.yusufzengin.movieviewer.model.data.Show
import com.yusufzengin.movieviewer.model.data.getPosterUrl
import com.yusufzengin.movieviewer.util.formatDate
import com.yusufzengin.movieviewer.util.loadFromUrl
import kotlinx.android.synthetic.main.movie_detail_fragment.*
import javax.inject.Inject

class ShowDetailFragment : Fragment() {

    companion object {
        fun newInstance() = ShowDetailFragment()
    }

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: ShowDetailViewModel by viewModels(factoryProducer = { factory })

    private val args: ShowDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.show_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.setShowId(args.showId)
        viewModel.show.observe(this) {
            setUpUi(it)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as MyApp).getAppComponent().newFragmentComponent().inject(this)
    }

    private fun setUpUi(show: Show) {
        detail_image.loadFromUrl(show.getPosterUrl())
        detail_title_tv.text = show.originalName
        detail_release_date_tv.text = show.firstAirDate?.formatDate() ?: "-"
        detail_average_tv.text = show.voteAverage.toString()
        detail_overview_tv.text = show.overview
    }

}

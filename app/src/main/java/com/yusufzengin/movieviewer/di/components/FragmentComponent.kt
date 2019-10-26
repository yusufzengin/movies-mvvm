package com.yusufzengin.movieviewer.di.components

import com.yusufzengin.movieviewer.di.FragmentScope
import com.yusufzengin.movieviewer.di.viewmodel.ViewModelModule
import com.yusufzengin.movieviewer.ui.detail.movie.MovieDetailFragment
import com.yusufzengin.movieviewer.ui.detail.show.ShowDetailFragment
import com.yusufzengin.movieviewer.ui.list.favorites.FavoritesFragment
import com.yusufzengin.movieviewer.ui.list.movie.MovieListFragment
import com.yusufzengin.movieviewer.ui.list.show.ShowListFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [ViewModelModule::class])
interface FragmentComponent {

    fun inject(fragment: MovieListFragment)

    fun inject(fragment: ShowListFragment)

    fun inject(fragment: FavoritesFragment)

    fun inject(fragment: MovieDetailFragment)

    fun inject(fragment: ShowDetailFragment)

}
package com.yusufzengin.movieviewer.di.modules

import com.yusufzengin.movieviewer.di.viewmodel.ViewModelModule
import com.yusufzengin.movieviewer.ui.detail.movie.MovieDetailFragment
import com.yusufzengin.movieviewer.ui.detail.show.ShowDetailFragment
import com.yusufzengin.movieviewer.ui.list.favorites.FavoritesFragment
import com.yusufzengin.movieviewer.ui.list.movie.MovieListFragment
import com.yusufzengin.movieviewer.ui.list.show.ShowListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [ViewModelModule::class])
abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    internal abstract fun movieListFragment(): MovieListFragment

    @ContributesAndroidInjector
    internal abstract fun showListFragment(): ShowListFragment

    @ContributesAndroidInjector
    internal abstract fun favoritesListFragment(): FavoritesFragment

    @ContributesAndroidInjector
    internal abstract fun movieDetailFragment(): MovieDetailFragment

    @ContributesAndroidInjector
    internal abstract fun showDetailFragment(): ShowDetailFragment
}
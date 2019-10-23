package com.yusufzengin.movieviewer.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yusufzengin.movieviewer.ui.detail.movie.MovieDetailViewModel
import com.yusufzengin.movieviewer.ui.detail.show.ShowDetailViewModel
import com.yusufzengin.movieviewer.ui.list.movie.MovieListViewModel
import com.yusufzengin.movieviewer.ui.list.show.ShowListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel::class)
    internal abstract fun bindMovieListViewModel(viewModel: MovieListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ShowListViewModel::class)
    internal abstract fun bindShowListViewModel(viewModel: ShowListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    internal abstract fun bindMovieDetailViewModel(viewModel: MovieDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ShowDetailViewModel::class)
    internal abstract fun bindShowDetailViewModel(viewModel: ShowDetailViewModel): ViewModel



}
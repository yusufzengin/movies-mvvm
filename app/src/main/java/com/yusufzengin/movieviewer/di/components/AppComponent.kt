package com.yusufzengin.movieviewer.di.components

import com.yusufzengin.movieviewer.di.modules.AppModule
import com.yusufzengin.movieviewer.di.modules.DatabaseModule
import com.yusufzengin.movieviewer.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, DatabaseModule::class])
interface AppComponent {

    fun newFragmentComponent(): FragmentComponent

}
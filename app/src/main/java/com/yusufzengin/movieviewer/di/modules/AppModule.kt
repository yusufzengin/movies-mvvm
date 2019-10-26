package com.yusufzengin.movieviewer.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Singleton
    @Provides
    fun bindContext(): Context = this.application.applicationContext

    @Singleton
    @Provides
    fun bindApplication(): Application = this.application
}
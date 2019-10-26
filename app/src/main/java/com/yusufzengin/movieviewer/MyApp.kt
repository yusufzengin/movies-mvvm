package com.yusufzengin.movieviewer

import android.app.Application
import com.yusufzengin.movieviewer.di.components.AppComponent
import com.yusufzengin.movieviewer.di.components.DaggerAppComponent
import com.yusufzengin.movieviewer.di.modules.AppModule
import com.yusufzengin.movieviewer.di.modules.DatabaseModule
import com.yusufzengin.movieviewer.di.modules.NetworkModule

class MyApp : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule())
            .databaseModule(DatabaseModule())
            .build()
    }

    fun getAppComponent(): AppComponent {
        return appComponent
    }
}
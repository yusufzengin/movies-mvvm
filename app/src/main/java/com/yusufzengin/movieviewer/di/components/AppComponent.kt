package com.yusufzengin.movieviewer.di.components

import android.app.Application
import com.yusufzengin.movieviewer.MyApp
import com.yusufzengin.movieviewer.di.modules.AppModule
import com.yusufzengin.movieviewer.di.modules.DatabaseModule
import com.yusufzengin.movieviewer.di.modules.FragmentBindingModule
import com.yusufzengin.movieviewer.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        DatabaseModule::class,
        NetworkModule::class,
        FragmentBindingModule::class
    ]
)
interface AppComponent : AndroidInjector<MyApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
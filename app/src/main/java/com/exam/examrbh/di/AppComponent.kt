package com.exam.examrbh.di

import android.app.Application
import com.exam.examrbh.MyApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        NetworkModule::class,
        ActivityModule::class,
        AppModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<MyApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(application: MyApp)
}
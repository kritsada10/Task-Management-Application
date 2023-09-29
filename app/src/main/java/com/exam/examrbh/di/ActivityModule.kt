package com.exam.examrbh.di

import com.exam.examrbh.presentation.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun contributeProductListActivity(): HomeActivity

}
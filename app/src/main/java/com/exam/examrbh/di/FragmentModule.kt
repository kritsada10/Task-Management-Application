package com.exam.examrbh.di

import com.exam.examrbh.presentation.doing.DoingFragment
import com.exam.examrbh.presentation.done.DoneFragment
import com.exam.examrbh.presentation.todo.TodoFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentModule {


    @ContributesAndroidInjector
    abstract fun todoFragment(): TodoFragment

    @ContributesAndroidInjector
    abstract fun doingFragment(): DoingFragment

    @ContributesAndroidInjector
    abstract fun doneFragment(): DoneFragment

}
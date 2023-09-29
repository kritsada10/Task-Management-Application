package com.exam.examrbh.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.exam.examrbh.presentation.doing.DoingViewModel
import com.exam.examrbh.presentation.done.DonViewModel
import com.exam.examrbh.presentation.todo.TodoViewModel
import com.exam.examrbh.presentation.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindsHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TodoViewModel::class)
    abstract fun bindTodoViewModel(viewModel: TodoViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DoingViewModel::class)
    abstract fun bindDoingViewModel(viewModel: DoingViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DonViewModel::class)
    abstract fun bindDoneViewModel(viewModel: DonViewModel): ViewModel



}
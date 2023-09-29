package com.exam.examrbh.data.base

import android.os.Bundle
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel() : ViewModel() {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    fun getCompositeDisposable() = compositeDisposable
    fun Disposable.track() = compositeDisposable.add(this)
    open fun handleIntent(extras: Bundle) {}
    override fun onCleared() = compositeDisposable.dispose()

}
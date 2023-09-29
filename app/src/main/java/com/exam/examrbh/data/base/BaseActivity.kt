package com.exam.examrbh.data.base

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<DB : ViewDataBinding, VM : BaseViewModel> : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @get:LayoutRes
    protected abstract val layId: Int
    lateinit var binding: DB
    lateinit var viewModel: VM
    protected abstract val classTypeVM: Class<VM>

    lateinit var handler: Handler
    lateinit var runnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[classTypeVM]
        binding = DataBindingUtil.setContentView(this, layId)
        binding.lifecycleOwner = this
        init()
        initStartRequest()
        setUpViewModelStateObservers()
        handler = Handler(Looper.getMainLooper())
        runnable = Runnable {
            finish()
        }
        startHandler()
    }

    open fun init() {}

    open fun initStartRequest() {}

    open fun setUpViewModelStateObservers() {}

    override fun onUserInteraction() {
        super.onUserInteraction()
        stopHandler()
        startHandler()
    }

    private fun stopHandler() {
        handler.removeCallbacks(runnable)
    }
    private fun startHandler() {
        handler.postDelayed(runnable, 10000.toLong())
    }
}
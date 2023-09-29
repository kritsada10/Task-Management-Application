package com.exam.examrbh.data.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.exam.examrbh.util.customui.RecyclerViewLoadMoreScroll
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<DB : ViewDataBinding, VM : BaseViewModel> : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var scrollListener: RecyclerViewLoadMoreScroll

    @get:LayoutRes
    protected abstract val layoutId: Int
    lateinit var binding : DB
    lateinit var viewModel : VM
    lateinit var viewFragment : View
    protected abstract val classTypeOfViewModel: Class<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[classTypeOfViewModel]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewFragment = view
        init()
        initStartRequest()
        setUpViewModelStateObservers()
        setUpRecyclerView()
        setScrollRecyclerView()
    }

    open fun initStartRequest() {}
    open fun init() {}
    open fun setUpViewModelStateObservers() {}
    open fun setUpRecyclerView(){}
    open fun setScrollRecyclerView(){}

}
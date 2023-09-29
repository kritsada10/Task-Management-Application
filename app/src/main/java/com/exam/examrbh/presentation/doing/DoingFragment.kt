package com.exam.examrbh.presentation.doing

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exam.examrbh.R
import com.exam.examrbh.data.base.BaseFragment
import com.exam.examrbh.data.enumclass.EnumRouteType
import com.exam.examrbh.databinding.ItemPagerLayoutBinding
import com.exam.examrbh.domain.interfaceclass.OnLoadMoreListener
import com.exam.examrbh.presentation.doing.adapter.DoingAdapter
import com.exam.examrbh.util.SetDecoration
import com.exam.examrbh.util.customui.SwipeToDelete
import com.exam.examrbh.util.customui.RecyclerItemDecoration
import com.exam.examrbh.util.customui.RecyclerViewLoadMoreScroll

class DoingFragment : BaseFragment<ItemPagerLayoutBinding, DoingViewModel>() {

    override val layoutId: Int = R.layout.item_pager_layout
    override val classTypeOfViewModel: Class<DoingViewModel> = DoingViewModel::class.java

    private lateinit var adapterDoing: DoingAdapter

    private var mCurrentOffset = 0

    private lateinit var mLayoutManager: RecyclerView.LayoutManager

    private var loadParameter = true

    override fun init() {
        mLayoutManager = LinearLayoutManager(viewFragment.context)
        adapterDoing = DoingAdapter()
    }

    override fun initStartRequest() {
        viewModel.callUpDoing(mCurrentOffset, EnumRouteType.DOING.name)
    }

    override fun setUpViewModelStateObservers() {
        viewModel.liveDataAllDoing.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                adapterDoing.setData(it)
            } else {
                mCurrentOffset--
            }
        }
    }

    override fun setUpRecyclerView() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val space = SetDecoration.calculateDecoration(resources.displayMetrics)
        binding.mainRecyclerView.layoutManager = mLayoutManager
        binding.mainRecyclerView.addItemDecoration(RecyclerItemDecoration(space))
        binding.mainRecyclerView.adapter = adapterDoing
        val swipeToDeleteCallBack = object : SwipeToDelete() {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                adapterDoing.removeData(viewHolder.bindingAdapterPosition)
            }
        }
        val itemTouch = ItemTouchHelper(swipeToDeleteCallBack)
        itemTouch.attachToRecyclerView(binding.mainRecyclerView)
    }

    override fun setScrollRecyclerView() {
        scrollListener =
            RecyclerViewLoadMoreScroll(mLayoutManager as LinearLayoutManager, loadParameter)
        scrollListener.setOnLoadMoreListener(object : OnLoadMoreListener {
            override fun onLoadMore() {
                mCurrentOffset++
                loadParameter = false
                initStartRequest()
                loadMoreData()
            }
        })
        binding.mainRecyclerView.addOnScrollListener(scrollListener)
    }

    private fun loadMoreData() {
        loadParameter = true
    }

}
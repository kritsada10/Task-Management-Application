package com.exam.examrbh.presentation.done

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exam.examrbh.R
import com.exam.examrbh.data.base.BaseFragment
import com.exam.examrbh.data.enumclass.EnumRouteType
import com.exam.examrbh.databinding.ItemPagerLayoutBinding
import com.exam.examrbh.domain.interfaceclass.OnLoadMoreListener
import com.exam.examrbh.presentation.done.adapter.DoneAdapter
import com.exam.examrbh.util.SetDecoration
import com.exam.examrbh.util.customui.SwipeToDelete
import com.exam.examrbh.util.customui.RecyclerItemDecoration
import com.exam.examrbh.util.customui.RecyclerViewLoadMoreScroll

class DoneFragment : BaseFragment<ItemPagerLayoutBinding, DonViewModel>() {

    override val layoutId: Int = R.layout.item_pager_layout
    override val classTypeOfViewModel: Class<DonViewModel> = DonViewModel::class.java


    private lateinit var adapterDone: DoneAdapter

    private var mCurrentOffset = 0

    private lateinit var mLayoutManager: RecyclerView.LayoutManager

    private var loadParameter = true

    override fun init() {
        mLayoutManager = LinearLayoutManager(viewFragment.context)
        adapterDone = DoneAdapter()
    }

    override fun initStartRequest() {
        viewModel.callUpDone(mCurrentOffset, EnumRouteType.DONE.name)
    }

    override fun setUpViewModelStateObservers() {
        viewModel.liveDataAllDone.observe(viewLifecycleOwner) {
            if(it.isNotEmpty()){
                adapterDone.setData(it)
            }
            else{
                mCurrentOffset--
            }
        }
    }

    override fun setUpRecyclerView() {
        initRecyclerView()
    }

    private fun initRecyclerView(){
        val space = SetDecoration.calculateDecoration(resources.displayMetrics)
        binding.mainRecyclerView.layoutManager = mLayoutManager
        binding.mainRecyclerView.addItemDecoration(RecyclerItemDecoration(space))
        binding.mainRecyclerView.adapter = adapterDone
        val swipeToDeleteCallBack = object : SwipeToDelete(){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                adapterDone.removeData(viewHolder.bindingAdapterPosition)
            }
        }
        val itemTouch = ItemTouchHelper(swipeToDeleteCallBack)
        itemTouch.attachToRecyclerView(binding.mainRecyclerView)
    }

    override fun setScrollRecyclerView() {
        scrollListener = RecyclerViewLoadMoreScroll(mLayoutManager as LinearLayoutManager, loadParameter)
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
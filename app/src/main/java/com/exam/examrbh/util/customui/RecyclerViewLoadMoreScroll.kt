package com.exam.examrbh.util.customui

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exam.examrbh.domain.interfaceclass.OnLoadMoreListener

class RecyclerViewLoadMoreScroll(layoutManager: LinearLayoutManager, private val loadMore: Boolean) :
    RecyclerView.OnScrollListener() {

    private var previousTotalItemCount = 0

    private lateinit var mOnLoadMoreListener: OnLoadMoreListener

    private var lLayoutManager: RecyclerView.LayoutManager = layoutManager

    fun setOnLoadMoreListener(mOnLoadMoreListener: OnLoadMoreListener) {
        this.mOnLoadMoreListener = mOnLoadMoreListener
    }

    override fun onScrolled(view: RecyclerView, dx: Int, dy: Int) {
        if (dy > 0)
        {
            if(loadMore) {
                var lastVisibleItemPosition = 0
                val totalItemCount = lLayoutManager.itemCount

                when (lLayoutManager) {
                    is LinearLayoutManager -> lastVisibleItemPosition =
                        (lLayoutManager as LinearLayoutManager).findLastVisibleItemPosition()
                }

                if (totalItemCount < previousTotalItemCount) {
                    previousTotalItemCount = totalItemCount
                }
                if (totalItemCount > previousTotalItemCount) {
                    previousTotalItemCount = totalItemCount
                }

                if (lastVisibleItemPosition + 2 > totalItemCount) {
                    mOnLoadMoreListener.onLoadMore()
                }
            }


        }
    }
    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        when (newState) {
            RecyclerView.SCROLL_STATE_IDLE -> {}
            RecyclerView.SCROLL_STATE_DRAGGING -> {}
            RecyclerView.SCROLL_STATE_SETTLING -> {
            }
        }

    }


}
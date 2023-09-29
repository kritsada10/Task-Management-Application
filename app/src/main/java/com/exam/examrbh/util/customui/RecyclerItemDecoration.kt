package com.exam.examrbh.util.customui

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RecyclerItemDecoration(private val space: Int): RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val isLast = position == state.itemCount - 1
        if(isLast){
            outRect.bottom = space
            outRect.top = 0
        }
        if(position == 0){
            outRect.top = space
            if(!isLast)
                outRect.bottom = 0;
        }
    }


}
package com.exam.examrbh.presentation.doing.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exam.examrbh.data.model.SubDataDisplay
import com.exam.examrbh.databinding.ItemWidgetLayoutBinding

class SubDoingAdapter: RecyclerView.Adapter<SubDoingAdapter.SubDoingHolder>() {

    private var list: List<SubDataDisplay> = arrayListOf()

    fun setUpAdapterSub(item: List<SubDataDisplay>) {
        this.list = item
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubDoingHolder {
        val binding =
            ItemWidgetLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubDoingHolder(binding)
    }

    override fun getItemCount(): Int {

        return list.size
    }

    override fun onBindViewHolder(holder: SubDoingHolder, position: Int) {
        holder.bindSubDoing(list[position])
    }


    class SubDoingHolder(private val view: ItemWidgetLayoutBinding) :
        RecyclerView.ViewHolder(view.root) {

        fun bindSubDoing(dataDisplay: SubDataDisplay) {
            view.txtTopicSubAdapter.text = dataDisplay.titleSub
            view.txtDescSubAdapter.text = dataDisplay.descriptionSub
        }
    }

}
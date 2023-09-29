package com.exam.examrbh.presentation.done.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exam.examrbh.data.model.SubDataDisplay
import com.exam.examrbh.databinding.ItemWidgetLayoutBinding

class SubDoneAdapter : RecyclerView.Adapter<SubDoneAdapter.SubDoneHolder>(){

    private var list: List<SubDataDisplay> = arrayListOf()

    fun setUpAdapterSub(item: List<SubDataDisplay>) {
        this.list = item
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubDoneHolder {
        val binding =
            ItemWidgetLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubDoneHolder(binding)
    }

    override fun getItemCount(): Int {

        return list.size
    }

    override fun onBindViewHolder(holder: SubDoneHolder, position: Int) {
        holder.bindSubDone(list[position])
    }

    class SubDoneHolder(private val view: ItemWidgetLayoutBinding) :
        RecyclerView.ViewHolder(view.root) {

        fun bindSubDone(dataDisplay: SubDataDisplay) {
            view.txtTopicSubAdapter.text = dataDisplay.titleSub
            view.txtDescSubAdapter.text = dataDisplay.descriptionSub
        }
    }

}
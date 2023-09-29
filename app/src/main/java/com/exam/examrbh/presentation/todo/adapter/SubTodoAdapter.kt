package com.exam.examrbh.presentation.todo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exam.examrbh.data.model.SubDataDisplay
import com.exam.examrbh.databinding.ItemWidgetLayoutBinding

class SubTodoAdapter : RecyclerView.Adapter<SubTodoAdapter.SubTodoHolder>() {

    private var list: List<SubDataDisplay> = arrayListOf()

    fun setUpAdapterSub(item: List<SubDataDisplay>) {
        this.list = item
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubTodoHolder {
        val binding =
            ItemWidgetLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubTodoHolder(binding)
    }

    override fun getItemCount(): Int {

        return list.size
    }

    override fun onBindViewHolder(holder: SubTodoHolder, position: Int) {
        holder.bindSubTodo(list[position])
    }


    class SubTodoHolder(private val view: ItemWidgetLayoutBinding) :
        RecyclerView.ViewHolder(view.root) {

        fun bindSubTodo(dataDisplay: SubDataDisplay) {
            view.txtTopicSubAdapter.text = dataDisplay.titleSub
            view.txtDescSubAdapter.text = dataDisplay.descriptionSub
        }
    }
}
package com.exam.examrbh.presentation.todo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exam.examrbh.data.model.DataDisplay
import com.exam.examrbh.databinding.ItemListLayoutBinding
import com.exam.examrbh.util.DateConverter


class TodoAdapter :  RecyclerView.Adapter<TodoAdapter.TodoHolder>(){

    private var listItem : ArrayList<DataDisplay> = ArrayList()

    private val subAdapter = SubTodoAdapter()

    @SuppressLint("NotifyDataSetChanged")
    fun setAdapter(item: List<DataDisplay>){
        item.map {
            this.listItem.add(it)
        }
        notifyDataSetChanged()
    }

    fun removeData(position: Int){
        this.listItem.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder {
        val binding = ItemListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoHolder(binding)
    }

    override fun getItemCount(): Int {
       return listItem.size
    }

    override fun onBindViewHolder(holder: TodoHolder, position: Int) {
        holder.bindingHolder(listItem[position])
    }

    inner class TodoHolder(private val view: ItemListLayoutBinding): RecyclerView.ViewHolder(view.root){

        fun bindingHolder(dataDisplay: DataDisplay){

            val dataDate = DateConverter.convertDate(dataDisplay.titleData)
            view.headerItem.text = dataDate
            subAdapter.setUpAdapterSub(dataDisplay.subDataDisplay)
            view.subItemRecyclerView.layoutManager = LinearLayoutManager(view.root.context, LinearLayoutManager.VERTICAL, false)
            view.subItemRecyclerView.adapter = subAdapter

        }


    }




}
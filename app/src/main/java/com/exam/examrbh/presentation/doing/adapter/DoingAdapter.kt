package com.exam.examrbh.presentation.doing.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exam.examrbh.data.model.DataDisplay
import com.exam.examrbh.databinding.ItemListLayoutBinding
import com.exam.examrbh.util.DateConverter

class DoingAdapter : RecyclerView.Adapter<DoingAdapter.DoingHolder>() {

    private var listItem : ArrayList<DataDisplay> = ArrayList()

    private var subAdapter = SubDoingAdapter()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<DataDisplay>){
        data.map {
            this.listItem.add(it)
        }
        notifyDataSetChanged()
    }

    fun removeData(position: Int){
        this.listItem.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoingHolder {

        val binding = ItemListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DoingHolder(binding)

    }

    override fun onBindViewHolder(holder: DoingHolder, position: Int) {
        holder.bindingHolder(listItem[position])
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

   inner class DoingHolder(private val view: ItemListLayoutBinding): RecyclerView.ViewHolder(view.root){

        fun bindingHolder(dataDisplay: DataDisplay){

            val dataDate = DateConverter.convertDate(dataDisplay.titleData)
            view.headerItem.text = dataDate
            subAdapter.setUpAdapterSub(dataDisplay.subDataDisplay)
            view.subItemRecyclerView.layoutManager = LinearLayoutManager(view.root.context, LinearLayoutManager.VERTICAL, false)
            view.subItemRecyclerView.adapter = subAdapter

        }

    }

}
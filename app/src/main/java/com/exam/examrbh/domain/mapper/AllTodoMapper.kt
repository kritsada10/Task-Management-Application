package com.exam.examrbh.domain.mapper

import android.annotation.SuppressLint
import com.exam.examrbh.data.model.DataDisplay
import com.exam.examrbh.data.model.SubDataDisplay
import com.exam.examrbh.data.model.response.AllDataResponse
import com.exam.examrbh.data.model.response.Task
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AllTodoMapper @Inject constructor() : Mapper<AllDataResponse, List<DataDisplay>> {

    override fun mapFrom(item: AllDataResponse): List<DataDisplay> {
        var result : List<DataDisplay> = arrayListOf()
        val task = item.tasks
        if(task.isNotEmpty()){
            val dataDisplay = ArrayList<DataDisplay>()
            task.forEach {
                dataDisplay.add(DataDisplay(titleData = it.createdAt,
                    subDataDisplay = getSubDataDisplay(it)))
            }
                result = dataDisplay.groupBy { it.titleData }.entries.map { (name, group) ->
                DataDisplay(name, group.flatMap { it.subDataDisplay })
            }
        }

        return result
    }

    @SuppressLint("SuspiciousIndentation")
    private fun getSubDataDisplay(task: Task): ArrayList<SubDataDisplay> {
        val data = ArrayList<SubDataDisplay>()
        data.add(
            SubDataDisplay(
                descriptionSub = task.description,
                idSub = task.id,
                statusSub = task.status,
                titleSub = task.title
            )
        )
        return data
    }

}

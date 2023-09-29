package com.exam.examrbh.data.model.response

import com.google.gson.annotations.SerializedName

data class AllDataResponse(
    @SerializedName("pageNumber")
    val pageNumber: Int,
    @SerializedName("tasks")
    val tasks: List<Task>,
    @SerializedName("totalPages")
    val totalPages: Int
)
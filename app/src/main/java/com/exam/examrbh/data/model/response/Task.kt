package com.exam.examrbh.data.model.response

import com.google.gson.annotations.SerializedName

data class Task(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("title")
    val title: String
)
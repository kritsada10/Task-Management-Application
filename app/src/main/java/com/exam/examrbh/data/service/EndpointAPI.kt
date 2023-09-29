package com.exam.examrbh.data.service

import com.exam.examrbh.data.model.response.AllDataResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface EndpointAPI {

    @GET("todo-list")
    fun getAllData(): Observable<AllDataResponse>

    @GET("todo-list")
    fun getQueryData(@Query("offset")offset: Int,
                     @Query("limit")limit: Int = 10,
                     @Query("sortBy")sortBy: String = "createdAt",
                     @Query("isAsc")isAsc: Boolean = true,
                     @Query("status")status: String): Observable<AllDataResponse>

}
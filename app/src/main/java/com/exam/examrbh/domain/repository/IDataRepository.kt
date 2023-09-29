package com.exam.examrbh.domain.repository

import com.exam.examrbh.data.model.response.AllDataResponse
import io.reactivex.Observable

interface IDataRepository {

    fun getAllDataInit(): Observable<AllDataResponse>

    fun getQueryInit(
        offset: Int,
        status: String
    ): Observable<AllDataResponse>

}
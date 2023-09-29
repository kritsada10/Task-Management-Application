package com.exam.examrbh.data.repository

import com.exam.examrbh.data.model.response.AllDataResponse
import com.exam.examrbh.data.service.EndpointAPI
import com.exam.examrbh.domain.repository.IDataRepository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiRepository @Inject constructor(private val api: EndpointAPI): IDataRepository {
    override fun getAllDataInit(): Observable<AllDataResponse> = api.getAllData()
    override fun getQueryInit(
        offset: Int,
        status: String
    ): Observable<AllDataResponse> = api.getQueryData(offset = offset, status = status)


}
package com.exam.examrbh.domain.usecase

import com.exam.examrbh.data.model.DataDisplay
import com.exam.examrbh.data.repository.ApiRepository
import com.exam.examrbh.domain.mapper.AllTodoMapper
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataListCallUseCase @Inject constructor(
    private val repository: ApiRepository,
    private val itemMapper: AllTodoMapper
    ) {

    fun getDataQuery(
        offset: Int,
        status: String
    ): Observable<List<DataDisplay>>{
        return repository.getQueryInit(offset,status).map { itemMapper.mapFrom(it) }
    }

}
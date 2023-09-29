package com.exam.examrbh.presentation.done

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.exam.examrbh.data.base.BaseViewModel
import com.exam.examrbh.data.model.DataDisplay
import com.exam.examrbh.domain.usecase.DataListCallUseCase
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DonViewModel @Inject constructor(private val dataListCallUseCase: DataListCallUseCase): BaseViewModel() {

    private val listAllDataDone = MutableLiveData<List<DataDisplay>>()

    val liveDataAllDone : LiveData<List<DataDisplay>> = listAllDataDone

    @SuppressLint("CheckResult")
    fun callUpDone(offset: Int, status: String){
        val dataObserve = getViewModelDataMore(offset, status)
        dataObserve.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe ({ data ->
                this.listAllDataDone.value = data
            }, {throwable ->
                Log.e("TAG", throwable.message.toString())
            })
    }

    private fun getViewModelDataMore(offset: Int, status: String): Observable<List<DataDisplay>> {
        return dataListCallUseCase.getDataQuery(offset, status)
    }

}
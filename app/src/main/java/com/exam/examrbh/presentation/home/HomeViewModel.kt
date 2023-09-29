package com.exam.examrbh.presentation.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.exam.examrbh.data.base.BaseViewModel
import com.exam.examrbh.data.model.response.AllDataResponse
import com.exam.examrbh.domain.usecase.DataListCallUseCase
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class HomeViewModel @Inject constructor(private val dataListCallUseCase: DataListCallUseCase) : BaseViewModel()  {

}
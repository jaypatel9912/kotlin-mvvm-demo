package com.kotlinmvvm.model

import com.kotlinmvvm.data.OperationCallback
import com.kotlinmvvm.model.Museum


interface MuseumDataSource {

    fun retrieveMuseums(callback: OperationCallback<Museum>)
    fun cancel()
}
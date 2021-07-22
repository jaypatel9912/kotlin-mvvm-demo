package com.kotlinmvvm.model

import com.kotlinmvvm.data.OperationCallback
import com.kotlinmvvm.model.Museum
import com.kotlinmvvm.model.MuseumDataSource


class MuseumRepository(private val museumDataSource: MuseumDataSource) {

    fun fetchMuseums(callback: OperationCallback<Museum>) {
        museumDataSource.retrieveMuseums(callback)
    }

    fun cancel() {
        museumDataSource.cancel()
    }
}
package com.kotlinmvvm.data

import com.kotlinmvvm.model.Museum


data class MuseumResponse(val status: Int?, val msg: String?, val data: List<Museum>?) {
    fun isSuccess(): Boolean = (status == 200)
}
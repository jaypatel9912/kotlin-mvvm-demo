package com.kotlinmvvm.data


interface OperationCallback<T> {
    fun onSuccess(data: List<T>?)
    fun onError(error: String?)
}
package com.kotlinmvvm.data

import com.kotlinmvvm.model.ClevelandArtwork
import com.kotlinmvvm.model.ClevelandResponse
import com.kotlinmvvm.model.MuseumDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MuseumRemoteDataSource(apiClient: ApiClient) : MuseumDataSource {

    private var call: Call<ClevelandResponse>? = null
    private val service = apiClient.build()

    override fun retrieveMuseums(callback: OperationCallback<ClevelandArtwork>) {

        call = service?.getArtworks()
        call?.enqueue(object : Callback<ClevelandResponse> {
            override fun onFailure(call: Call<ClevelandResponse>, t: Throwable) {
                callback.onError(t.message)
            }

            override fun onResponse(
                call: Call<ClevelandResponse>,
                response: Response<ClevelandResponse>
            ) {
                response.body()?.let {
                    if (response.isSuccessful) {
                        callback.onSuccess(it.data)
                    } else {
                        callback.onError("Unkonwn error")
                    }
                }
            }
        })
    }

    override fun cancel() {
        call?.let {
            it.cancel()
        }
    }
}
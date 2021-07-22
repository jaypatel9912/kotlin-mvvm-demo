package com.kotlinmvvm.di

import androidx.lifecycle.ViewModelProvider
import com.kotlinmvvm.data.ApiClient
import com.kotlinmvvm.data.MuseumRemoteDataSource
import com.kotlinmvvm.model.MuseumDataSource
import com.kotlinmvvm.model.MuseumRepository
import com.kotlinmvvm.viewmodel.ViewModelFactory


object Injection {

    private val museumDataSource: MuseumDataSource = MuseumRemoteDataSource(ApiClient)
    private val museumRepository = MuseumRepository(museumDataSource)
    private val museumViewModelFactory = ViewModelFactory(museumRepository)

    fun providerRepository(): MuseumDataSource {
        return museumDataSource
    }

    fun provideViewModelFactory(): ViewModelProvider.Factory {
        return museumViewModelFactory
    }
}
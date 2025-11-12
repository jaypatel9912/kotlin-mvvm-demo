package com.kotlinmvvm.mapper

import com.kotlinmvvm.model.ClevelandArtwork
import com.kotlinmvvm.model.Museum

fun ClevelandArtwork.toMuseum(): Museum {
    return Museum(
        id = this.id ?: 0,
        name = this.title ?: "",
        image = this.images?.web?.url ?: "",
        artist = this.creators?.firstOrNull()?.description,
        date = this.creationDate,
        description = this.description ?: this.description,
        department = this.department,
        medium = this.measurements ?: this.technique,
    )
}

fun List<ClevelandArtwork>.toMuseumList(): List<Museum> {
    return this.map { it.toMuseum() }
}
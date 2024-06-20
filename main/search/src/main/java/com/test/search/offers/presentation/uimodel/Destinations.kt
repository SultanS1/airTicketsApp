package com.test.search.offers.presentation.uimodel

import com.test.search.offers.domain.model.DestinationsModel

data class Destinations(
    var start: String,
    var destination: String
)

fun DestinationsModel.toUI(): Destinations{
    return Destinations(
        start,
        destination
    )
}

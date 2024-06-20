package com.test.search.offers.domain.model

data class TicketOfferModel(
    val id: Int,
    val title: String,
    val timeRange: String,
    val price: Int
)
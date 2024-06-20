package com.test.search.offers.data.dto

import com.test.search.offers.domain.model.TicketOfferModel

data class TicketDto(
    val id: Int,
    val title: String,
    val time_range: List<String>,
    val price: PriceDto
)

fun TicketDto.toModel(): TicketOfferModel{
    return TicketOfferModel(
        id,
        title,
        time_range.joinToString(" "),
        price.value
    )
}

package com.test.search.tickets.data.dto

import com.test.search.tickets.domain.model.ArrivalModel
import com.test.search.tickets.domain.model.DepartureModel
import com.test.search.tickets.domain.model.TicketModel

data class TicketDto(
    val id: Int,
    val badge: String?,
    val price: PriceDto,
    val provider_name: String,
    val company: String,
    val departure: DepartureDto,
    val arrival: ArrivalDto,
    val has_transfer: Boolean,
    val has_visa_transfer: Boolean,
    val luggage: LuggageDto?,
    val hand_luggage: HandLuggageDto,
    val is_returnable: Boolean,
    val is_exchangable: Boolean
)

fun TicketDto.toModel(): TicketModel{
    return TicketModel(
        id,
        badge,
        price.value,
        provider_name,
        company,
        DepartureModel(departure.town, departure.date, departure.airport),
        ArrivalModel(arrival.town, arrival.date, arrival.airport),
        has_transfer,
        has_visa_transfer,
        luggage?.has_luggage,
        luggage?.price?.value,
        hand_luggage.has_hand_luggage,
        hand_luggage.size,
        is_returnable,
        is_exchangable
    )
}

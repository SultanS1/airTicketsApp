package com.test.search.tickets.domain.model


data class TicketModel(
    val id: Int,
    val badge: String?,
    val price: Int,
    val provider_name: String,
    val company: String,
    val departure: DepartureModel,
    val arrival: ArrivalModel,
    val has_transfer: Boolean,
    val has_visa_transfer: Boolean,

    val has_luggage: Boolean?,
    val priceLuggage: Int?,
    val has_hand_luggage: Boolean,
    val size: String?,

    val is_returnable: Boolean,
    val is_exchangable: Boolean
)

package com.test.search.tickets.presentation.uimodel

import com.test.core.adapterDelegate.DelegateAdapterItem
import com.test.search.tickets.domain.model.TicketModel
import java.text.NumberFormat
import java.util.Locale

data class Ticket(
    val id: Int,
    val badge: String?,
    val price: String,
    val provider_name: String,
    val company: String,
    val dtown: String,
    val ddate: String,
    val dairport: String,
    val atown: String,
    val adate: String,
    val aairport: String,
    val has_transfer: Boolean,
    val has_visa_transfer: Boolean,

    val has_luggage: Boolean?,
    val priceLuggage: Int?,
    val has_hand_luggage: Boolean,
    val size: String?,

    val is_returnable: Boolean,
    val is_exchangable: Boolean,
    val flightDuration: String
): DelegateAdapterItem {
    override fun id(): Any {
        return id
    }

    override fun content(): Any {
        return company
    }
}

fun TicketModel.toUI(): Ticket{
    return Ticket(
        id,
        badge,
        "${formatPrice(price)} ₽",
        provider_name,
        company,
        departure.town,
        parseTime(departure.date),
        departure.airport,
        arrival.town,
        parseTime(arrival.date),
        arrival.airport,
        has_transfer,
        has_visa_transfer,
        has_luggage,
        priceLuggage,
        has_hand_luggage,
        size,
        is_returnable,
        is_exchangable,
        calculateDuration(parseTime(departure.date), parseTime(arrival.date)).toString() + "ч"
    )
}

fun formatPrice(price: Int): String {
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault())
    return formatter.format(price).replace(",", " ")
}

fun calculateDuration(start: String, end: String): Double {
    val (startHour, startMinute) = start.split(":").map { it.toInt() }
    val (endHour, endMinute) = end.split(":").map { it.toInt() }

    val startTotalMinutes = startHour * 60 + startMinute
    val endTotalMinutes = endHour * 60 + endMinute

    val durationMinutes = endTotalMinutes - startTotalMinutes
    return roundDuration(durationMinutes / 60.0)
}

fun roundDuration(duration: Double): Double {
    val rounded = (duration * 2).toInt() / 2.0
    return if (rounded % 1 == 0.5) rounded else rounded.toInt().toDouble()
}

fun parseTime(dateString: String): String {
    return dateString.substring(dateString.length-8,dateString.length-3)
}
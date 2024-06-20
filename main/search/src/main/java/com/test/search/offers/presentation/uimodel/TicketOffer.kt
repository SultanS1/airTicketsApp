package com.test.search.offers.presentation.uimodel

import com.test.core.adapterDelegate.DelegateAdapterItem
import com.test.search.offers.domain.model.TicketOfferModel
import java.text.NumberFormat
import java.util.Locale

data class TicketOffer(
    val id: Int,
    val title: String,
    val timeRange: String,
    val price: String
): DelegateAdapterItem {
    override fun id(): Any {
        return id
    }

    override fun content(): Any {
        return title
    }
}

fun TicketOfferModel.toUI(): TicketOffer{
    return TicketOffer(
        id,
        title,
        timeRange,
        "${formatPrice(price)} ₽"
    )
}

fun formatPrice(price: Int): String {
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault())
    return formatter.format(price).replace(",", " ")
}

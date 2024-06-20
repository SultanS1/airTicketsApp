package com.test.main.presentation.uimodel

import com.test.core.adapterDelegate.DelegateAdapterItem
import com.test.main.domain.model.OfferModel
import java.text.NumberFormat
import java.util.Locale

data class Offer(
    val id: Int,
    val title: String,
    val town: String,
    val image: String,
    val price: String
): DelegateAdapterItem {
    override fun id(): Any {
        return id
    }

    override fun content(): Any {
        return title
    }
}

fun OfferModel.toUI(): Offer {
    return Offer(
        id,
        title,
        town,
        image,
        "от ${formatPrice(price)} ₽"
    )
}

fun formatPrice(price: Int): String {
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault())
    return formatter.format(price).replace(",", " ")
}

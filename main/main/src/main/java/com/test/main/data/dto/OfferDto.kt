package com.test.main.data.dto
import com.test.main.domain.model.OfferModel

data class OfferDto(
    val id: Int,
    val title: String,
    val town: String,
    var image: String,
    val price: PriceDto
)

/**
 * Extension function to map DTO to domain model
 */
fun OfferDto.toModel(): OfferModel{
    return OfferModel(
        id,
        title,
        town,
        image,
        price.value
    )
}

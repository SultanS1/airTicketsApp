package com.test.search.offers.data.repositoryImpl

import com.test.search.offers.data.dto.toModel
import com.test.search.offers.data.local.Preferences
import com.test.search.offers.data.remote.TicketOffersApi
import com.test.search.offers.domain.model.DestinationsModel
import com.test.search.offers.domain.model.TicketOfferModel
import com.test.search.offers.domain.repository.TicketOffersRepository

/**
 * Implementation of the [TicketOffersRepository] interface.
 */
class TicketOffersRepositoryImpl(private val api: TicketOffersApi, private val preferences: Preferences): TicketOffersRepository {

    override suspend fun getTickets(): List<TicketOfferModel> {
        return api.getTickets().tickets_offers.map { it.toModel() }
    }

    override fun getDestinations(): DestinationsModel {
        return DestinationsModel(preferences.getStart()!!, preferences.getDestination()!!)
    }

    override fun saveFlightDate(flightDate: String) {
        preferences.saveFlightDate(flightDate)
    }

}
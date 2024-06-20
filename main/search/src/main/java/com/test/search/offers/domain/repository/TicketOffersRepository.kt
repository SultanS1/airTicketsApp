package com.test.search.offers.domain.repository

import com.test.search.offers.domain.model.DestinationsModel
import com.test.search.offers.domain.model.TicketOfferModel

/**
 * Repository interface for managing ticket offers data and user preferences related to flight details.
 * This interface defines methods for fetching ticket offers, retrieving destinations information,
 * and saving flight date preferences.
 */
interface TicketOffersRepository {

    /**
     * Fetches a list of ticket offers from the repository.
     *
     * @return A suspend function that returns a list of [TicketOfferModel] objects representing the fetched ticket offers.
     */
    suspend fun getTickets(): List<TicketOfferModel>

    /**
     * Retrieves the destinations information from the repository.
     *
     * @return A [DestinationsModel] object containing destinations information.
     */
    fun getDestinations(): DestinationsModel

    /**
     * Saves the selected flight date as a user preference.
     *
     * @param flightDate The flight date to be saved in a string format.
     */
    fun saveFlightDate(flightDate: String)

}
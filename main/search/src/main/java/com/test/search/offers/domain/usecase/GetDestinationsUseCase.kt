package com.test.search.offers.domain.usecase

import com.test.search.offers.domain.repository.TicketOffersRepository

/**
 * Use case class responsible for retrieving destinations information from the repository.
 * This class abstracts the logic for fetching destinations data and provides a simple interface
 * for accessing this information.
 *
 * @param repository The [TicketOffersRepository] implementation to use for fetching destinations data.
 */
class GetDestinationsUseCase(private val repository: TicketOffersRepository) {

    /**
     * Retrieves the destinations information from the repository.
     *
     * @return A [DestinationsModel] object containing destinations information.
     */
    fun getDestinations() = repository.getDestinations()

}
package com.test.search.offers.domain.usecase

import com.test.search.offers.domain.repository.TicketOffersRepository

/**
 * Use case class responsible for retrieving ticket offers from the repository.
 * This class abstracts the logic for fetching ticket offers data and provides a simple interface
 * for accessing this information asynchronously.
 *
 * @param repository The [TicketOffersRepository] implementation to use for fetching ticket offers data.
 */
class GetOffersUseCase(private val repository: TicketOffersRepository) {

    /**
     * Retrieves ticket offers from the repository asynchronously.
     *
     * @return A list of TicketOfferModel objects representing ticket offers.
     */
    suspend fun getTickets() = repository.getTickets()

}
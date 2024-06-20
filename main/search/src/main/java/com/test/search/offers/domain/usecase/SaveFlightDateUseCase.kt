package com.test.search.offers.domain.usecase

import com.test.search.offers.domain.repository.TicketOffersRepository

/**
 * Use case class responsible for saving the flight date.
 * This class abstracts the logic for saving the flight date and provides a simple interface
 * for performing this action.
 *
 * @param repository The [TicketOffersRepository] implementation to use for saving the flight date.
 */
class SaveFlightDateUseCase(private val repository: TicketOffersRepository){

    /**
     * Saves the flight date to the repository.
     *
     * @param flightDate The flight date to be saved.
     */
    fun saveFlightDate(flightDate: String) = repository.saveFlightDate(flightDate)

}
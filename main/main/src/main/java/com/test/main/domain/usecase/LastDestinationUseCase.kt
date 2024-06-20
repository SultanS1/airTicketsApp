package com.test.main.domain.usecase

import com.test.main.domain.repository.OffersRepository

/**
 * Triggers getLastDestination method of [OffersRepository]
 */
class LastDestinationUseCase(private val repository: OffersRepository) {

    fun getLastDestination() = repository.getLastDestination()

}
package com.test.main.domain.usecase

import com.test.main.domain.repository.OffersRepository

/**
 * Triggers finalDestination method of [OffersRepository] to save final destination localy
 */
class SaveFinalDestinationUseCase(private val repository: OffersRepository) {

    fun saveFinalDestination(destination: String){
        repository.finalDestination(destination)
    }

}
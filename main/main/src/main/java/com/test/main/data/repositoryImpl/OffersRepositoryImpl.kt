package com.test.main.data.repositoryImpl

import com.test.main.data.dto.toModel
import com.test.main.data.local.Preferences
import com.test.main.data.remote.OffersApi
import com.test.main.domain.model.OfferModel
import com.test.main.domain.repository.OffersRepository

/**
 * Implementation of the [OffersRepository] interface.
 * This repository handles data operations related to offers, including fetching offers from the API
 * and managing user preferences for destinations.
 *
 * @property api The API service used to fetch offers(now it is mock api).
 * @property preferences The preferences manager used to store and retrieve user destination preferences.
 */
class OffersRepositoryImpl(private val api: OffersApi, private val preferences: Preferences): OffersRepository {

    override suspend fun getOffers(): List<OfferModel> {
        val result = api.getOffers()
        return result.offers.map { it.toModel() }
    }

    override fun getLastDestination(): String? {
        return preferences.getLastDestination()
    }

    override fun saveDestination(destination: String) {
        preferences.saveNewDestination(destination)
    }

    override fun finalDestination(destination: String) {
        preferences.saveFinalDestination(destination)
    }


}
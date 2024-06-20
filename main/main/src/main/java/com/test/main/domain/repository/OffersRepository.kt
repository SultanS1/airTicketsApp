package com.test.main.domain.repository

import com.test.main.domain.model.OfferModel

/**
 * Repository interface for managing offers data and user preferences related to destinations.
 * This interface defines methods for fetching offers, retrieving and saving destination preferences.
 */
interface OffersRepository {

    /**
     * Fetches a list of offers from the repository.
     *
     * @return A suspend function that returns a list of [OfferModel] objects representing the fetched offers.
     */
    suspend fun getOffers(): List<OfferModel>


    /**
     * Retrieves the last destination saved by the user.
     *
     * @return The last destination saved by the user, or null if no destination has been saved.
     */
    fun getLastDestination(): String?

    /**
     * Saves a new destination as the user's last destination preference.
     *
     * @param destination The destination to be saved.
     */
    fun saveDestination(destination: String)

    /**
     * Saves a destination as the user's final destination preference.
     *
     * @param destination The final destination to be saved.
     */
    fun finalDestination(destination: String)

}
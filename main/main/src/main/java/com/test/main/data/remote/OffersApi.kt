package com.test.main.data.remote

import com.test.main.data.dto.OffersResponse
import retrofit2.http.GET

/**
 * Interface for network calls
 */
interface OffersApi {

    @GET("v3/ad9a46ba-276c-4a81-88a6-c068e51cce3a")
    suspend fun getOffers(): OffersResponse

}
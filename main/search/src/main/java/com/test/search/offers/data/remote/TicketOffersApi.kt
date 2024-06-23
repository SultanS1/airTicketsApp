package com.test.search.offers.data.remote

import com.test.search.offers.data.dto.TicketsOfferResponse
import retrofit2.http.GET

/**
 * Mock class for imitating network calls
 */
interface TicketOffersApi {

    @GET("v3/38b5205d-1a3d-4c2f-9d77-2f9d1ef01a4a")
    suspend fun getTickets(): TicketsOfferResponse

}
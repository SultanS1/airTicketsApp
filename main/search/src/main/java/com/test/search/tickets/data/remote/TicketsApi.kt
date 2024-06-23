package com.test.search.tickets.data.remote

import com.test.search.tickets.data.dto.TicketResponse
import retrofit2.http.GET

/**
 * Mock class for imitating network calls
 */
interface TicketsApi {

    @GET("v3/c0464573-5a13-45c9-89f8-717436748b69")
    suspend fun getTickets(): TicketResponse

}
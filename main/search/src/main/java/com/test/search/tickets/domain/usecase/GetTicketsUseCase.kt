package com.test.search.tickets.domain.usecase

import com.test.search.tickets.domain.repository.TicketsRepository

class GetTicketsUseCase(private val repository: TicketsRepository) {

    suspend fun getTickets() = repository.getAllTickets()

}
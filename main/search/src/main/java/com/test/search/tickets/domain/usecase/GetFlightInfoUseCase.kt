package com.test.search.tickets.domain.usecase

import com.test.search.tickets.domain.repository.TicketsRepository

class GetFlightInfoUseCase(private val repository: TicketsRepository) {

    fun getFlightInfo() = repository.getInfo()

}
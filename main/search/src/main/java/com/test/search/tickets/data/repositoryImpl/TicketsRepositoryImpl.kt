package com.test.search.tickets.data.repositoryImpl

import com.test.search.tickets.data.dto.toModel
import com.test.search.tickets.data.local.Preference
import com.test.search.tickets.data.remote.TicketsApi
import com.test.search.tickets.domain.model.FlightInfoModel
import com.test.search.tickets.domain.model.TicketModel
import com.test.search.tickets.domain.repository.TicketsRepository

class TicketsRepositoryImpl(private val api: TicketsApi, private val preference: Preference): TicketsRepository {

    override suspend fun getAllTickets(): List<TicketModel> {
        return api.getTickets().tickets.map { it.toModel() }
    }

    override fun getInfo(): FlightInfoModel {
        return FlightInfoModel(
            preference.getStart(),
            preference.getDestination(),
            preference.getDate()
        )
    }

}
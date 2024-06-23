package com.test.search.tickets.di

import com.test.common.navigation.NavigateTo
import com.test.core.navigation.NavigationRouter
import com.test.search.offers.data.remote.TicketOffersApi
import com.test.search.tickets.data.local.Preference
import com.test.search.tickets.data.remote.TicketsApi
import com.test.search.tickets.data.repositoryImpl.TicketsRepositoryImpl
import com.test.search.tickets.domain.repository.TicketsRepository
import com.test.search.tickets.domain.usecase.GetFlightInfoUseCase
import com.test.search.tickets.domain.usecase.GetTicketsUseCase
import com.test.search.tickets.presentation.TicketsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val ticketsModule = module {

    single { getTicketsApi(get()) }
    single { Preference(androidContext()) }
    single<TicketsRepository> { TicketsRepositoryImpl(get(), get()) }
    single { GetTicketsUseCase(get()) }
    single { GetFlightInfoUseCase(get()) }
    viewModel{ TicketsViewModel(get<NavigationRouter<NavigateTo>>(),get(), get()) }

}

fun getTicketsApi(retrofit: Retrofit): TicketsApi {
    return retrofit.create(TicketsApi::class.java)
}
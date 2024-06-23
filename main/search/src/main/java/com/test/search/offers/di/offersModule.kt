package com.test.search.offers.di

import com.test.common.navigation.NavigateTo
import com.test.core.navigation.NavigationRouter
import com.test.search.offers.data.local.Preferences
import com.test.search.offers.data.remote.TicketOffersApi
import com.test.search.offers.data.repositoryImpl.TicketOffersRepositoryImpl
import com.test.search.offers.domain.repository.TicketOffersRepository
import com.test.search.offers.domain.usecase.GetDestinationsUseCase
import com.test.search.offers.domain.usecase.GetOffersUseCase
import com.test.search.offers.domain.usecase.SaveFlightDateUseCase
import com.test.search.offers.presentation.OffersViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val offersModule = module {

    single { getTicketOffersApi(get()) }
    single { Preferences(androidContext()) }
    single<TicketOffersRepository> { TicketOffersRepositoryImpl(get(), get()) }
    single { GetDestinationsUseCase(get()) }
    single { GetOffersUseCase(get()) }
    single { SaveFlightDateUseCase(get()) }
    viewModel{ OffersViewModel(get<NavigationRouter<NavigateTo>>(), get(), get(), get()) }

}

fun getTicketOffersApi(retrofit: Retrofit): TicketOffersApi{
    return retrofit.create(TicketOffersApi::class.java)
}
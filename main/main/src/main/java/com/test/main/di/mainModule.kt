package com.test.main.di

import com.test.common.navigation.NavigateTo
import com.test.core.navigation.NavigationRouter
import com.test.main.data.local.Preferences
import com.test.main.data.remote.OffersApi
import com.test.main.data.repositoryImpl.OffersRepositoryImpl
import com.test.main.domain.repository.OffersRepository
import com.test.main.domain.usecase.LastDestinationUseCase
import com.test.main.domain.usecase.OffersUseCase
import com.test.main.domain.usecase.SaveDestinationUseCase
import com.test.main.domain.usecase.SaveFinalDestinationUseCase
import com.test.main.presentation.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit


val mainModule = module {

    single { getOffersApi(get()) }
    single { Preferences(androidContext()) }
    single<OffersRepository> { OffersRepositoryImpl(get(), get()) }
    single { OffersUseCase(get()) }
    single { SaveDestinationUseCase(get()) }
    single { LastDestinationUseCase(get()) }
    single { SaveFinalDestinationUseCase(get()) }
    viewModel{ MainViewModel(get<NavigationRouter<NavigateTo>>(), get(), get(), get(), get()) }

}

fun getOffersApi(retrofit: Retrofit): OffersApi{
    return retrofit.create(OffersApi::class.java)
}
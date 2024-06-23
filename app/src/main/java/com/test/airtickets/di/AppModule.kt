package com.test.airtickets.di

import com.test.airtickets.application.MainApplication
import com.test.airtickets.router.NavigationRouterImpl
import com.test.common.navigation.NavigateTo
import com.test.common.utils.Constants
import com.test.core.navigation.NavigationRouter
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule =  module {

    single<NavigationRouter<NavigateTo>> { NavigationRouterImpl(MainApplication.INSTANCE.router) }
    single { getRetrofit() }

}

fun getRetrofit(): Retrofit{
    return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
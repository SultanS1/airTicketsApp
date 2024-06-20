package com.test.airtickets.di

import com.test.airtickets.application.MainApplication
import com.test.airtickets.router.NavigationRouterImpl
import com.test.common.navigation.NavigateTo
import com.test.core.navigation.NavigationRouter
import org.koin.dsl.module


val appModule =  module {

    single<NavigationRouter<NavigateTo>> { NavigationRouterImpl(MainApplication.INSTANCE.router) }

}
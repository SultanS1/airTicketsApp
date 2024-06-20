package com.test.airtickets.application

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.test.airtickets.di.appModule
import com.test.main.di.mainModule
import com.test.search.offers.di.offersModule
import com.test.search.tickets.di.ticketsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Application class for managing global application state and dependencies.
 */
class MainApplication : Application(){

    private val cicerone = Cicerone.create()

    val router get() = cicerone.router

    val navigatorHolder get() = cicerone.getNavigatorHolder()

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        startKoin {
            androidContext(this@MainApplication)
            modules(appModule, mainModule, offersModule, ticketsModule)
        }
    }

    companion object {
        // Singleton instance of the application
        internal lateinit var INSTANCE: MainApplication
            private set
    }

}
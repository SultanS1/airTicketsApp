package com.test.airtickets.router

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.test.hotels.HotelsFragment
import com.test.locations.LocationsFragment
import com.test.main.presentation.MainFragment
import com.test.profile.ProfileFragment
import com.test.search.offers.presentation.OffersFragment
import com.test.search.tickets.presentation.TicketsFragment
import com.test.subscribes.SubscribesFragment

/**
 * Object containing screens for navigation within the application.
 */
object AppScreens {

    //Tickets section screens
    fun mainFragment() = FragmentScreen { MainFragment() }
    fun chooseCountryFragment() = FragmentScreen() { OffersFragment() }
    fun seeAllFragment() = FragmentScreen { TicketsFragment() }

    //Other sections
    fun hotelsFragment() = FragmentScreen { HotelsFragment() }
    fun locationFragment() = FragmentScreen { LocationsFragment() }
    fun subscribesFragment() = FragmentScreen { SubscribesFragment() }
    fun profileFragment() = FragmentScreen { ProfileFragment() }

}
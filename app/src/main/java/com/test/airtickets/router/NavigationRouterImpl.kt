package com.test.airtickets.router

import com.github.terrakok.cicerone.Router
import com.test.common.navigation.NavigateTo
import com.test.common.utils.Constants
import com.test.core.navigation.NavigationRouter

/**
 * Implementation of the [NavigationRouter] interface using Cicerone's router.
 *
 * @param router The Cicerone router instance to handle navigation.
 */
class NavigationRouterImpl(private val router: Router): NavigationRouter<NavigateTo> {

    override fun navigateTo(action: NavigateTo) {
        when(action){
            is NavigateTo.TicketsSection -> router.navigateTo(AppScreens.mainFragment())
            is NavigateTo.OffersFragment -> router.navigateTo(AppScreens.chooseCountryFragment())
            is NavigateTo.TicketsFragment -> router.navigateTo(AppScreens.seeAllFragment())

            is NavigateTo.HotelsSection -> router.navigateTo(AppScreens.hotelsFragment())
            is NavigateTo.LocationsSection -> router.navigateTo(AppScreens.locationFragment())
            is NavigateTo.SubscribesSection -> router.navigateTo(AppScreens.subscribesFragment())
            is NavigateTo.ProfileSection -> router.navigateTo(AppScreens.profileFragment())
        }
    }

    override fun pop() {
        router.exit()
    }

    override fun replace(action: NavigateTo) {
        navigateTo(action)
    }

}
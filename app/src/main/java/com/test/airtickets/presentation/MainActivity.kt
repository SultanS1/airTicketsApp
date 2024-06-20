package com.test.airtickets.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.test.airtickets.R
import com.test.airtickets.application.MainApplication
import com.test.airtickets.databinding.ActivityMainBinding
import com.test.airtickets.router.NavigationRouterImpl
import com.test.common.navigation.NavigateTo

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding:ActivityMainBinding by viewBinding(R.id.tickets)

    private val appNavigator by lazy { AppNavigator(this, R.id.MainContainer) }

    private val appInstance = MainApplication.INSTANCE

    private val navigatorHolder = appInstance.navigatorHolder

    private val router = NavigationRouterImpl(appInstance.router)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            onTabSelected(item.itemId)
            true
        }

        // Set up the navigator
        navigatorHolder.setNavigator(appNavigator)

    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(appNavigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    fun onTabSelected(tabId: Int) {
        when (tabId) {
            R.id.tickets -> router.navigateTo(NavigateTo.TicketsSection)
            R.id.hostels -> router.navigateTo(NavigateTo.HotelsSection)
            R.id.locations -> router.navigateTo(NavigateTo.LocationsSection)
            R.id.subscriptions -> router.navigateTo(NavigateTo.SubscribesSection)
            R.id.profile -> router.navigateTo(NavigateTo.ProfileSection)
        }
    }

}
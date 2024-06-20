package com.test.common.navigation

/**
 * Sealed interface representing navigation Intent, it is sent to main router then according to type defined here main router
 * decides which screen navigate to
 */
sealed interface NavigateTo {
    /**
     * Represents navigation to the tickets section of the application.
     */
    data object TicketsSection : NavigateTo

    /**
     * Represents navigation to the offers fragment within the application.
     */
    data object OffersFragment : NavigateTo

    /**
     * Represents navigation to the tickets fragment within the application.
     */
    data object TicketsFragment : NavigateTo

    /**
     * Represents navigation to the hotels section of the application.
     */
    data object HotelsSection : NavigateTo

    /**
     * Represents navigation to the locations section of the application.
     */
    data object LocationsSection : NavigateTo

    /**
     * Represents navigation to the subscribes section of the application.
     */
    data object SubscribesSection : NavigateTo

    /**
     * Represents navigation to the profile section of the application.
     */
    data object ProfileSection : NavigateTo
}

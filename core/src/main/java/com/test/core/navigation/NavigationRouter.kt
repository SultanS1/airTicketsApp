package com.test.core.navigation

/**
 * Interface navigator for entire app.
 */
interface NavigationRouter<T> {

    fun navigateTo(action: T)

    fun pop()

    fun replace(action: T)

}
package com.test.search.tickets.data.local

import android.content.Context
import com.test.common.utils.Constants

/**
 * Preference gets needed info from local storage
 */
class Preference(context: Context) {

    private val pref = context.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE)

    fun getStart(): String?{
        return pref.getString(Constants.KEY_LAST_DESTINATION, "")
    }

    fun getDestination(): String?{
        return pref.getString(Constants.DESTINATION, "")
    }

    fun getDate(): String?{
        return pref.getString(Constants.FLIGHT_DATE, "")
    }

}
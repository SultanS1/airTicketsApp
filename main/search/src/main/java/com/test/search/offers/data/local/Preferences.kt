package com.test.search.offers.data.local

import android.content.Context
import com.test.common.utils.Constants
import com.test.search.offers.data.dto.TravelInfoDto

/**
 * Preference gets needed info from local storage
 */
class Preferences(context: Context) {

    private val pref = context.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE)

    fun getStart(): String?{
        return pref.getString(Constants.KEY_LAST_DESTINATION, "")
    }

    fun getDestination(): String?{
        return pref.getString(Constants.DESTINATION, "")
    }

    fun saveFlightDate(flightDate: String){
        pref.edit().putString(Constants.FLIGHT_DATE, flightDate).apply()
    }

}
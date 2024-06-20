package com.test.main.data.local

import android.annotation.SuppressLint
import android.content.Context
import com.test.common.utils.Constants

/**
 * Preference gets needed info from local storage
 */
class Preferences(context: Context) {

    private val pref = context.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE)

    @SuppressLint("CommitPrefEdits")
    fun saveNewDestination(destination: String){
        pref.edit().putString(Constants.KEY_LAST_DESTINATION, destination).apply()
    }

    fun getLastDestination(): String?{
        return pref.getString(Constants.KEY_LAST_DESTINATION, "")
    }

    fun saveFinalDestination(destination: String){
        pref.edit().putString(Constants.DESTINATION, destination).apply()
    }

}
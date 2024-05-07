package com.geeks.lovecalculate.utils

import android.content.SharedPreferences
import javax.inject.Inject

class Pref @Inject constructor(
    private var pref: SharedPreferences
) {

    fun onShowed(): Boolean {
        return pref.getBoolean(SHOWED_KEY, true)
    }

    fun onBoardingShow() {
        pref.edit().putBoolean(SHOWED_KEY, false).apply()
    }

    companion object {
        const val SHOWED_KEY = "showed.key"
    }
}

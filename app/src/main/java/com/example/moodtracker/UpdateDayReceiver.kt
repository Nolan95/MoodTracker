package com.example.moodtracker

import android.content.BroadcastReceiver
import android.content.Context
import android.content.SharedPreferences
import android.content.Intent
import utils.KEY_CURRENT_DAY
import utils.PREFERENCES


class UpdateDayReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
//        var sharedPreferences : SharedPreferences = getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
//
//        var currentDay = sharedPreferences.getInt(KEY_CURRENT_DAY, 1)
//        currentDay++
//        sharedPreferences.edit().putInt(KEY_CURRENT_DAY, currentDay).apply()
    }
}

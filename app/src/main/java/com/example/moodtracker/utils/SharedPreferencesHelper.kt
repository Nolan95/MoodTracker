package com.example.moodtracker.utils

import android.content.SharedPreferences
import com.example.moodtracker.data.Mood
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*


fun saveComment(comment: String, moods: MutableList<Mood>, sharedPreferences: SharedPreferences) {
    val mood = moods.last()
    mood.mComment = comment
    sharedPreferences.edit().putString(MOODS, moodListToJson(moods)).apply()
}



fun saveMood(moodIndex: Int, moods: MutableList<Mood>, sharedPreferences: SharedPreferences) {
    val mood = moods.last()
    mood.mMood = moodIndex
    sharedPreferences.edit().putString(MOODS, moodListToJson(moods)).apply()
}

fun moodListToJson(moods: MutableList<Mood>): String? {
    val gson = Gson()
    return gson.toJson(moods)
}

fun jsonToMoodList(sharedPreferences: SharedPreferences): MutableList<Mood> {
    val gson = Gson()
    val moodsJson = sharedPreferences.getString(MOODS, "")
    if (moodsJson == "") return mutableListOf<Mood>(
        Mood(
            mMood = 3,
            isToday = true,
            mDate = Calendar.getInstance().time
        )
    )
    val groupListType = object : TypeToken<MutableList<Mood>>() {

    }.type

    return gson.fromJson(moodsJson, groupListType)
}
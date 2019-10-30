package com.example.moodtracker.data


import java.util.*


data class Mood(var mMood: Int = 2,
                var mComment: String ="",
                var mDate: Date = Date(),
                var isToday:Boolean = true)
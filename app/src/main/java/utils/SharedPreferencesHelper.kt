package utils

import android.content.SharedPreferences


fun saveComment(comment: String, currentDay: Int, preferences: SharedPreferences) {
    preferences.edit().putString(KEY_CURRENT_COMMENT, comment).apply()
    when (currentDay) {
        1 -> preferences.edit().putString(KEY_COMMENT0, comment).apply()
        2 -> preferences.edit().putString(KEY_COMMENT1, comment).apply()
        3 -> preferences.edit().putString(KEY_COMMENT2, comment).apply()
        4 -> preferences.edit().putString(KEY_COMMENT3, comment).apply()
        5 -> preferences.edit().putString(KEY_COMMENT4, comment).apply()
        6 -> preferences.edit().putString(KEY_COMMENT5, comment).apply()
        7 -> preferences.edit().putString(KEY_COMMENT6, comment).apply()
        else -> {
            preferences.edit().putString(KEY_COMMENT0, preferences.getString(KEY_COMMENT1, ""))
                .apply()
            preferences.edit().putString(KEY_COMMENT1, preferences.getString(KEY_COMMENT2, ""))
                .apply()
            preferences.edit().putString(KEY_COMMENT2, preferences.getString(KEY_COMMENT3, ""))
                .apply()
            preferences.edit().putString(KEY_COMMENT3, preferences.getString(KEY_COMMENT4, ""))
                .apply()
            preferences.edit().putString(KEY_COMMENT4, preferences.getString(KEY_COMMENT5, ""))
                .apply()
            preferences.edit().putString(KEY_COMMENT5, preferences.getString(KEY_COMMENT6, ""))
                .apply()
            preferences.edit().putString(KEY_COMMENT6, comment).apply()
        }
    }
}



fun saveMood(moodIndex: Int, currentDay: Int, preferences: SharedPreferences) {
    preferences.edit().putInt(KEY_CURRENT_MOOD, moodIndex).apply()
    when (currentDay) {
        1 -> preferences.edit().putInt(KEY_MOOD0, moodIndex).apply()
        2 -> preferences.edit().putInt(KEY_MOOD1, moodIndex).apply()
        3 -> preferences.edit().putInt(KEY_MOOD2, moodIndex).apply()
        4 -> preferences.edit().putInt(KEY_MOOD3, moodIndex).apply()
        5 -> preferences.edit().putInt(KEY_MOOD4, moodIndex).apply()
        6 -> preferences.edit().putInt(KEY_MOOD5, moodIndex).apply()
        7 -> preferences.edit().putInt(KEY_MOOD6, moodIndex).apply()
        else -> {
            preferences.edit().putInt(KEY_MOOD0, preferences.getInt(KEY_MOOD1, 3)).apply()
            preferences.edit().putInt(KEY_MOOD1, preferences.getInt(KEY_MOOD2, 3)).apply()
            preferences.edit().putInt(KEY_MOOD2, preferences.getInt(KEY_MOOD3, 3)).apply()
            preferences.edit().putInt(KEY_MOOD3, preferences.getInt(KEY_MOOD4, 3)).apply()
            preferences.edit().putInt(KEY_MOOD4, preferences.getInt(KEY_MOOD5, 3)).apply()
            preferences.edit().putInt(KEY_MOOD5, preferences.getInt(KEY_MOOD6, 3)).apply()
            preferences.edit().putInt(KEY_MOOD6, moodIndex).apply()
        }
    }
}
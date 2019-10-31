package com.example.moodtracker

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moodtracker.data.Mood
import com.example.moodtracker.utils.*

class MoodHistoryActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var moodsRecyclerView : RecyclerView
    private var moods = mutableListOf<Mood>()
    private lateinit var moodAdapter : MoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mood_history)

        sharedPreferences = getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)

        moods = jsonToMoodList(sharedPreferences)

        moodAdapter = MoodAdapter(this@MoodHistoryActivity, moods)


        moodsRecyclerView = findViewById(R.id.recycler_moods)
        moodsRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MoodHistoryActivity)

            adapter = moodAdapter
        }


    }
}

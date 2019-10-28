package com.example.moodtracker

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import utils.*

class MoodHistoryActivity : AppCompatActivity() {

    private var sharePreferences : SharedPreferences? = null
    private var currentDay : Int = 0
    private lateinit var moodsRecyclerView : RecyclerView
    private var moods = ArrayList<Int>()
    private var comments = ArrayList<String>()
    private lateinit var moodAdapter : MoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mood_history)

        sharePreferences = getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)

        currentDay = sharePreferences!!.getInt(KEY_CURRENT_DAY, 1)

        for (i in 0 until currentDay) {
            moods.add(sharePreferences!!.getInt("KEY_MOOD$i", 3))
            comments.add(sharePreferences!!.getString("KEY_COMMENT$i", "")!!)
        }

        moodAdapter = MoodAdapter(this@MoodHistoryActivity, moods, comments)


        moodsRecyclerView = findViewById(R.id.recycler_moods)
        moodsRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MoodHistoryActivity, LinearLayoutManager.VERTICAL, true)

            adapter = moodAdapter
        }



    }
}

package com.example.moodtracker

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GestureDetectorCompat
import utils.*

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener{

    private lateinit var moodImageView : ImageView
    private lateinit var moodHistoryButton : ImageButton
    private lateinit var addCommentbutton : ImageButton
    private lateinit var mDetector: GestureDetectorCompat
    private lateinit var parentRelativeLayout: RelativeLayout

    private var currentDay : Int = 0
    private var currentMoodIndex : Int = 0
    private var currentComment : String? = ""

    private lateinit var sharedPreferences : SharedPreferences

    private lateinit var constant:Constants

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moodImageView = findViewById<ImageView>(R.id.my_mood)
        moodHistoryButton = findViewById(R.id.btn_mood_history)
        addCommentbutton = findViewById(R.id.btn_add_comment)
        parentRelativeLayout = findViewById(R.id.parent_relative_layout)

        mDetector = GestureDetectorCompat(this, this)


        sharedPreferences = getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
        currentDay = sharedPreferences.getInt(KEY_CURRENT_DAY, 1);
        currentMoodIndex = sharedPreferences.getInt(KEY_CURRENT_MOOD, 3);
        currentComment = sharedPreferences.getString(KEY_CURRENT_COMMENT, "");



        addCommentbutton.setOnClickListener {

            val builder = AlertDialog.Builder(this@MainActivity)
            val editText = EditText(this@MainActivity)

            builder.setMessage("Comment\uD83E\uDD14 \uD83D\uDCDD").setView(editText)
                .setPositiveButton("CONFIRM"){dialog, which ->
                    if(!editText.text.toString().isEmpty()){
                          saveComment(editText.getText().toString(), currentDay, sharedPreferences);
                    }
                    dialog.dismiss();
                    Toast.makeText(this@MainActivity, "Comment saved", Toast.LENGTH_SHORT).show()
                }

                .setNegativeButton(android.R.string.cancel){dialog, which ->
                    dialog.cancel()
                    Toast.makeText(this@MainActivity, "Comment canceled", Toast.LENGTH_SHORT).show()
                }
                .create().show()
        }


        moodHistoryButton.setOnClickListener {
            val intent = Intent(this, MoodHistoryActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (mDetector.onTouchEvent(event)) {
            true
        } else {
            super.onTouchEvent(event)
        }
    }

    override fun onDown(event: MotionEvent): Boolean {
        //Log.d(DEBUG_TAG, "onDown: $event")
        return true
    }

    override fun onFling(
        event1: MotionEvent,
        event2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        //Log.d(DEBUG_TAG, "onFling: $event1 $event2")
        val diffY = event2.y - event1.y
        if(Math.abs(diffY) > SWIPE_THRESHOLD){
            if(currentMoodIndex < 4){
                currentMoodIndex++
                changeUiMood(currentMoodIndex)
                saveMood(currentMoodIndex, currentDay, sharedPreferences)

            }
        }else if(Math.abs(diffY) < SWIPE_THRESHOLD){
            if(currentMoodIndex > 0){
                currentMoodIndex--
                changeUiMood(currentMoodIndex)
                saveMood(currentMoodIndex, currentDay, sharedPreferences)
            }
        }
        return true
    }

    override fun onLongPress(event: MotionEvent) {
        //Log.d(DEBUG_TAG, "onLongPress: $event")
    }

    override fun onScroll(
        event1: MotionEvent,
        event2: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        //Log.d(DEBUG_TAG, "onScroll: $event1 $event2")
        return true
    }

    override fun onShowPress(event: MotionEvent) {
        //Log.d(DEBUG_TAG, "onShowPress: $event")
    }

    override fun onSingleTapUp(event: MotionEvent): Boolean {
        //Log.d(DEBUG_TAG, "onSingleTapUp: $event")
        return true
    }

    fun changeUiMood(index : Int){
        moodImageView.setImageResource(constant.moodImageArray[index])
        parentRelativeLayout.setBackgroundResource(constant.moodColor[index])
    }
}

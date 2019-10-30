package com.example.moodtracker

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GestureDetectorCompat
import com.example.moodtracker.data.Mood
import com.example.moodtracker.utils.*
import kotlinx.android.synthetic.main.activity_login.*
import java.lang.Exception
import java.util.*

class LoginActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userPrefs = getSharedPreferences(USERPREFS, Context.MODE_PRIVATE)

        if (userPrefs.getString(USERNAME, "") != "") {
            setContentView(R.layout.activity_main)
            val name = userPrefs.getString(USERNAME, "")
            val welcomeBack = "Welcome back " + name
            Toast.makeText(applicationContext, welcomeBack, Toast.LENGTH_LONG).show()

        } else {

            setContentView(R.layout.activity_login)

            submit.setOnClickListener {

                if (username.text.toString() == ""
                    || password.text.toString() == "") {
                    Toast.makeText(applicationContext, "Please fill all fields", Toast.LENGTH_LONG).show()

                } else {

                    val editor = userPrefs.edit()
                    editor.apply{
                        putString(USERNAME, username.text.toString())
                        putString(PASSWORD, password.text.toString())
                    }.apply()

                    username.setText("")
                    password.setText("")
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    val welcome = "Welcome" + username.text.toString()
                    Toast.makeText(applicationContext, welcome, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}

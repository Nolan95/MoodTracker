package com.example.moodtracker

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.moodtracker.utils.USERNAME
import com.example.moodtracker.utils.USERPREFS

class SplashScreenActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long=3000 // 3 sec
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val userPrefs = getSharedPreferences(USERPREFS, Context.MODE_PRIVATE)
        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity
            if(userPrefs.getString(USERNAME, "") != ""){
                startActivity(Intent(this,MainActivity::class.java))
            }else{
                startActivity(Intent(this,LoginActivity::class.java))
            }

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
    }
}

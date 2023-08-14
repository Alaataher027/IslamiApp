package com.example.islamiapp.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.islamiapp.R
import com.example.islamiapp.ui.main.MainActivity

class Splash_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        starthomeactivity()
    }
    private fun starthomeactivity() {
        Handler(Looper.getMainLooper())
            .postDelayed({
                 val intent = Intent(this, MainActivity::class.java)
                 startActivity(intent)
            }
                ,2000)
    }
}
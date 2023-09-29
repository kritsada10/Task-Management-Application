package com.exam.examrbh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.exam.examrbh.databinding.ActivityMainBinding
import com.exam.examrbh.presentation.login.LoginActivity

class MainActivity : AppCompatActivity() {

    private lateinit var splashScreen : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashScreen = ActivityMainBinding.inflate(layoutInflater)
        setContentView(splashScreen.root)

        Handler(Looper.getMainLooper()).postDelayed({
           val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)

    }
}